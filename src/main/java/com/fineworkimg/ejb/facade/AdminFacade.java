package com.fineworkimg.ejb.facade;

import com.fineworkimg.core.ejb.bo.AdminBO;
import com.fineworkimg.core.ejb.entity.AdminUser;
import com.fineworkimg.core.ejb.entity.AdminUserLog;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless
public class AdminFacade implements Serializable {

    @EJB
    private AdminBO adminBO;

    public List<AdminUser> findSysUserList() throws Exception {
        return adminBO.findSysUserList();
    }

    public List<AdminUserLog> findSysUserLogList() throws Exception {
        return adminBO.findSysUserLogList();
    }

    public boolean isExistUser(String username, String email) throws Exception {
        return adminBO.isExistUser(username, email);
    }

    public void createAdminUser(AdminUser adminUser) throws Exception {
        adminBO.createAdminUser(adminUser);
    }

    public void editAdminUser(AdminUser adminUser) throws Exception {
        adminBO.editAdminUser(adminUser);
    }

    public void deleteAdminUser(AdminUser adminUser) throws Exception {
        adminBO.deleteAdminUser(adminUser);
    }

    public List<AdminUser> findAdminUserListByCriteria(String choice, String choiceValue, Integer status) throws Exception {
        return adminBO.findAdminUserListByCriteria(choice, choiceValue, status);
    }

    public List<AdminUserLog> findSysUserLogListByCriteria(String username, String firstname) throws Exception {
        return adminBO.findSysUserLogListByCriteria(username, firstname);
    }

}
