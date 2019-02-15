package com.fineworkimg.ejb.facade;


import com.fineworkimg.core.ejb.bo.CreateJobBO;
import com.fineworkimg.core.ejb.entity.SysCreatejob;
import com.fineworkimg.core.ejb.entity.SysCreatejobDetail;
import com.fineworkimg.core.ejb.entity.SysForeman;
import com.fineworkimg.core.ejb.entity.SysWorkunit;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Adisorn J.
 */
@Stateless
public class CreateJobFacade {

    @EJB
    private CreateJobBO createJobBO;

  
//=======================================================
    public List<SysCreatejob> findSysCreateJobListByCriteria(SysForeman foremanId,String documentno,SysWorkunit workunitId,Integer status,Date startDate, Date toDate) throws Exception {
       return createJobBO.findSysCreatejobListByCriteria(foremanId, documentno, workunitId, status, startDate, toDate);
    }
    
     public void createSysCreateJobDetail(SysCreatejobDetail sysCreatejobDetail) throws Exception {
       createJobBO.createSysCreateJobDetail(sysCreatejobDetail);
    }

   
    public void editSysCreateJobDetail(SysCreatejobDetail sysCreatejobDetail) throws Exception {
        createJobBO.editSysCreateJobDetail(sysCreatejobDetail);
    }

   
    public void deleteSysCreateJobDetail(SysCreatejobDetail sysCreatejobDetail) throws Exception {
       createJobBO.deleteSysCreateJobDetail(sysCreatejobDetail);
    }
}
