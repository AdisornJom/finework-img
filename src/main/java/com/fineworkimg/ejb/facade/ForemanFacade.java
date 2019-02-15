package com.fineworkimg.ejb.facade;

import com.fineworkimg.core.ejb.bo.ForemanBO;
import com.fineworkimg.core.ejb.entity.SysForeman;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Adisorn J.
 */
@Stateless
public class ForemanFacade {

    @EJB
    private ForemanBO foremanBO;

  
//=======================================================
    public SysForeman findSysForeman(Integer id) throws Exception{
        return foremanBO.findSysForeman(id);
    }
    
    public List<SysForeman> findSysForemanList() throws Exception {
       return foremanBO.findSysForemanList();
    }
    
    public SysForeman findSysForeman(SysForeman sysCustomer) throws Exception {
       return foremanBO.findSysForeman(sysCustomer);
    }
   
    public List<SysForeman> findSysForemanListByCriteria(String foremanNameTh,String status) throws Exception {
       return foremanBO.findSysForemanListByCriteria(foremanNameTh, status);
    }

   
    public void createSysForeman(SysForeman sysContractor) throws Exception {
       foremanBO.createSysForeman(sysContractor);
    }

   
    public void editSysForeman(SysForeman sysContractor) throws Exception {
        foremanBO.editSysForeman(sysContractor);
    }

   
    public void deleteSysForeman(SysForeman sysContractor) throws Exception {
       foremanBO.deleteSysForeman(sysContractor);
    }
    
    public boolean isExistUser(String username) throws Exception {
        return foremanBO.isExistUser(username);
    }
    
    public SysForeman findUserByUsername(String username) throws Exception {
        return foremanBO.findUserByUsername(username);
    }
}
