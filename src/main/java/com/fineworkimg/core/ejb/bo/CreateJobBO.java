package com.fineworkimg.core.ejb.bo;


import com.fineworkimg.core.ejb.entity.SysCreatejob;
import com.fineworkimg.core.ejb.entity.SysCreatejobDetail;
import com.fineworkimg.core.ejb.entity.SysForeman;
import com.fineworkimg.core.ejb.entity.SysWorkunit;
import com.fineworkimg.ejb.dao.SysCreateJobDAO;
import com.fineworkimg.ejb.dao.SysCreateJobDetailDAO;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Adisorn j.
 */
@Stateless(name = "fineworkimg.CreateJobBO")
public class CreateJobBO {

    @EJB
    private SysCreateJobDAO sysCreateJobDAO;
    @EJB
    private SysCreateJobDetailDAO sysCreateJobDetailDAO;

    public List<SysCreatejob> findSysCreatejobListByCriteria(SysForeman foremanId,String documentno,SysWorkunit workunitId,Integer status,Date startDate, Date toDate) throws Exception {
        List<SysCreatejob> sysCreatejob = sysCreateJobDAO.findSysCreatejobListByCriteria(foremanId,documentno,workunitId,status, startDate, toDate);
        for (SysCreatejob u : sysCreatejob) {
            u.getSysCreatejobDetailList().toString();
        }
        return sysCreatejob;
    }
    
    public void createSysCreateJobDetail(SysCreatejobDetail sysCreatejobDetail) throws Exception{
        sysCreateJobDetailDAO.edit(sysCreatejobDetail);
    }
    
    public void editSysCreateJobDetail(SysCreatejobDetail sysCreatejobDetail) throws Exception{
        sysCreateJobDetailDAO.edit(sysCreatejobDetail);
    }
    
    public void deleteSysCreateJobDetail (SysCreatejobDetail sysCreatejobDetail) throws Exception{
        sysCreateJobDetailDAO.edit(sysCreatejobDetail);
    }
}
