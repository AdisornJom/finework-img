package com.fineworkimg.core.ejb.bo;

import com.fineworkimg.core.ejb.entity.SysForeman;
import com.fineworkimg.ejb.dao.SysForemanDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Adisorn j.
 */
@Stateless(name = "fineworkimg.ForemanBO")
public class ForemanBO {

    @EJB
    private SysForemanDAO sysForemanDAO;

    //=========================
    public SysForeman findSysForeman(Integer id) throws Exception{
        return sysForemanDAO.find(id);
    }
    
    public List<SysForeman> findSysForemanList() throws Exception {
        return sysForemanDAO.findSysForemanList();
    }
     
    public SysForeman findSysForeman(SysForeman sysForeman) throws Exception {
        return sysForemanDAO.findSysForemanById(sysForeman.getForemanId());
    }
    
    public List<SysForeman> findSysForemanListByCriteria(String foremanNameTh,String status) throws Exception {
       return sysForemanDAO.findSysForemanByCriteria(foremanNameTh, status);
    }
    
    public void createSysForeman(SysForeman sysContractor) throws Exception{
        sysContractor.setStatus("Y");
        sysForemanDAO.create(sysContractor);
    }
    
    public void editSysForeman(SysForeman sysContractor) throws Exception{
        sysForemanDAO.edit(sysContractor);
    }
    
    public void deleteSysForeman (SysForeman sysContractor) throws Exception{
        sysForemanDAO.edit(sysContractor);
    }
    
    public boolean isExistUser(String username) throws Exception {
        SysForeman foreman = sysForemanDAO.isExistUser(username);
        return foreman != null;
    }
    
    public SysForeman findUserByUsername(String username) throws Exception {
        return sysForemanDAO.findByUsername(username);
    }

}
