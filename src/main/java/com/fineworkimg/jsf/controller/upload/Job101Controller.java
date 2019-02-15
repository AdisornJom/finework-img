package com.fineworkimg.jsf.controller.upload;

import com.fineworkimg.core.ejb.entity.SysCreatejob;
import com.fineworkimg.core.ejb.entity.SysCreatejobDetail;
import com.fineworkimg.core.ejb.entity.SysWorkunit;
import com.fineworkimg.core.util.Constants;
import com.fineworkimg.core.util.DateTimeUtil;
import com.fineworkimg.core.util.MessageBundleLoader;
import com.fineworkimg.core.util.UploadUtil;
import com.fineworkimg.ejb.facade.CreateJobFacade;
import com.fineworkimg.ejb.facade.CustomerFacade;
import com.fineworkimg.jsf.common.UserInfoController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author adisorn.jo
 */
@SessionScoped
@Named(Job101Controller.CONTROLLER_NAME)
public class Job101Controller implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(Job101Controller.class);
    public static final String CONTROLLER_NAME = "job101Controller";

    @Inject
    private CreateJobFacade createJobFacade;
    @Inject
    private UserInfoController userInfo;
    @Inject
    private CustomerFacade customerFacade;

    private Date date = new Date();

    //search
    private String documentno;
    private SysWorkunit workunit_find;
    private Date startDate;
    private Date toDate;

    private SysCreatejob selected;
    private List<SysCreatejob> items;
    private List<SysCreatejobDetail> detail;
    
    //private List<String> files;
    private UploadedFile file;
    private static final String NO_PRO = "no_pro.png";
    private String newFile = NO_PRO;

    @PostConstruct
    public void init() {
        //startDate
        Calendar cal = new GregorianCalendar(Locale.US);
        cal.setTime(DateTimeUtil.getSystemDate());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        startDate = cal.getTime();
        //toDate
        toDate = DateTimeUtil.getSystemDate();
        
        search();
    }
    
    public void search() {
        try {

            if (null != startDate) {
                //Init start date
                Calendar c1 = Calendar.getInstance();
                c1.setTime(startDate);
                c1.set(Calendar.HOUR_OF_DAY, 0);
                c1.set(Calendar.MINUTE, 0);
                c1.set(Calendar.SECOND, 0);
                startDate = c1.getTime();
            }
            if (null != toDate) {
                //Init to date
                Calendar c2 = Calendar.getInstance();
                c2.setTime(toDate);
                c2.set(Calendar.HOUR_OF_DAY, 23);
                c2.set(Calendar.MINUTE, 59);
                c2.set(Calendar.SECOND, 59);
                toDate = c2.getTime();
            }

            items = createJobFacade.findSysCreateJobListByCriteria(userInfo.getAdminUser(), documentno, workunit_find, Constants.COMMON_OPEN_STATUS, startDate, toDate);
        } catch (Exception ex) {
            LOG.error(ex.getMessage(), ex);
        }
    }
    
    public String edit() {
        try {
            
            if (null == detail || detail.isEmpty()) {
                Messages.addError("listForm:edit_msg", MessageBundleLoader.getMessageFormat("messages.code.2002", "อัพโหลดรูปภาพ"));
                RequestContext.getCurrentInstance().execute("window.scrollTo(0,0);");
                return null;
            }
//            if (!StringUtils.equals(NO_PRO, newFile)) {
//                // selected.setPromotionImg(pathImagesUrl(newFile));
//                selected.setPromotionImg(newFile);
//            }
            for(SysCreatejobDetail to:selected.getSysCreatejobDetailList()){
                createJobFacade.createSysCreateJobDetail(to);
            }
          //  clearData();
            search();
            return "index?faces-redirect=true";
        } catch (Exception ex) {
            Messages.addError("listForm:edit_msg", MessageBundleLoader.getMessage("messages.code.9001"));
            RequestContext.getCurrentInstance().execute("window.scrollTo(0,0);");
            LOG.error(ex.getMessage(), ex);
        }
        return null;
    }
    
    public String prepareEdit() {
        detail = new ArrayList();
        return "edit?faces-redirect=true";
    }
    
    public String redirectToIndex(){
        return "/ui/job/index?faces-redirect=true";
    }
    
    public String cancel(){
        return "index?faces-redirect=true";
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        file = event.getFile();
        if (file != null) {
            try {
                 // newFile = UploadUtil.uploadFile(file, "uploadJob", null, UUID.randomUUID().toString());
                //  files.add(UploadUtil.uploadFile(file, "uploadJob", null, UUID.randomUUID().toString()));
                  
                  SysCreatejobDetail to = new SysCreatejobDetail();
                  to.setJobId(selected);
                  to.setJobImg(UploadUtil.uploadFile(file, "uploadJob".concat("/").concat(selected.getWorkunitId().getWorkunitName()), null, UUID.randomUUID().toString()));
                  detail.add(to);
                  selected.getSysCreatejobDetailList().add(to);
                  Thread.sleep(1500);
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }
//        file = event.getFile();
//        if (file != null) {
//            InputStream fis = null;
//            try {
//
//                fis = file.getInputstream();
//                String contentType = file.getContentType();
//                String extension = contentType.substring(contentType.lastIndexOf("/") + 1);
//                newFile = UUID.randomUUID().toString() + "." + extension;
//                FTPUtil ftp = new FTPUtil();
//                ftp.uploadFile(fis, newFile, Constants.FTP_PATH_PRO);
//                ftp.disconnect();
//
//            } catch (IOException ex) {
//                LOG.error(ex.getMessage(), ex);
//            } catch (Exception ex) {
//                LOG.error(ex.getMessage(), ex);
//            } finally {
//                if (fis != null) {
//                    try {
//                        fis.close();
//                    } catch (IOException ex) {
//                    }
//                }
//            }
//        }
    }

    //Auto Complete==========================================================================  
    //Auto complete workunit search
    public List<SysWorkunit> completeSelectWorkunit(String query) {
        List<SysWorkunit> filteredWorkunit = new ArrayList<>();
        try {
            SysWorkunit sysWorkunit_ = new SysWorkunit();
            sysWorkunit_.setWorkunitId(null);
            sysWorkunit_.setWorkunitName("-");
            filteredWorkunit.add(sysWorkunit_);
            List<SysWorkunit> allWorkunit = customerFacade.findSysWorkunitList();
            for (SysWorkunit sysWorkunit : allWorkunit) {
                if (sysWorkunit.getWorkunitName() != null && sysWorkunit.getWorkunitName().length() > 0) {
                    if (sysWorkunit.getWorkunitName().toLowerCase().startsWith(query)) {
                        filteredWorkunit.add(sysWorkunit);
                    }
                }
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return filteredWorkunit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public SysWorkunit getWorkunit_find() {
        return workunit_find;
    }

    public void setWorkunit_find(SysWorkunit workunit_find) {
        this.workunit_find = workunit_find;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public SysCreatejob getSelected() {
        return selected;
    }

    public void setSelected(SysCreatejob selected) {
        this.selected = selected;
    }

    public List<SysCreatejob> getItems() {
        return items;
    }

    public void setItems(List<SysCreatejob> items) {
        this.items = items;
    }

    public List<SysCreatejobDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<SysCreatejobDetail> detail) {
        this.detail = detail;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getNewFile() {
        return newFile;
    }

    public void setNewFile(String newFile) {
        this.newFile = newFile;
    }

}
