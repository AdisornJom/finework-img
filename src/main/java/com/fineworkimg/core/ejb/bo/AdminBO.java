package com.fineworkimg.core.ejb.bo;

import com.fineworkimg.ejb.dao.AdminUserDAO;
import com.fineworkimg.ejb.dao.AdminUserLogDAO;
import com.fineworkimg.core.ejb.entity.AdminUser;
import com.fineworkimg.core.ejb.entity.AdminUserLog;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless(name = "fineworkimg.AdminBO")
public class AdminBO {

    @EJB
    private AdminUserDAO userDAO;
    @EJB
    private AdminUserLogDAO userLogDAO;


    public List<AdminUser> findSysUserList() throws Exception {
        List<AdminUser> rtnList = userDAO.findSysUserList();
//        for(AdminUser a : rtnList){
//            a.getAdminWhitelistList().toString();
//        }
        return rtnList;
    }

    public List<AdminUserLog> findSysUserLogList() throws Exception {
        return userLogDAO.findAll();
    }

    public List<AdminUser> findAdminUserListByCriteria(String choice, String choiceValue, Integer status) throws Exception {
        List<AdminUser> list = userDAO.findAdminUserListByCriteria(choice, choiceValue, status);
//        for (AdminUser l : list) {
//            l.getAdminWhitelistList().toString();
//        }
        return list;
    }

    public List<AdminUserLog> findSysUserLogListByCriteria(String username, String firstname) throws Exception {
        return userLogDAO.findSysUserLogListByCriteria(username, firstname);
    }

    public boolean isExistUser(String username, String email) throws Exception {
        AdminUser useradmin = userDAO.findByExistUser(username, email);
        return useradmin != null;
    }

    public void createAdminUser(AdminUser adminUser) throws Exception {
        adminUser.setId(UUID.randomUUID().toString());
        adminUser.setStatus(1);
        adminUser.setUsed(1);
        userDAO.create(adminUser);
    }

    public void editAdminUser(AdminUser adminUser) throws Exception {
        userDAO.edit(adminUser);
    }

    public void deleteAdminUser(AdminUser adminUser) throws Exception {
        userDAO.edit(adminUser);
    }
   
}
