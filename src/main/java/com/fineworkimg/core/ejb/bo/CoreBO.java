/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.ejb.bo;

import com.fineworkimg.ejb.dao.AdminUserDAO;
import com.fineworkimg.ejb.dao.AdminUserLogDAO;
import com.fineworkimg.core.ejb.entity.AdminUser;
import com.fineworkimg.core.ejb.entity.AdminUserLog;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless(name = "fineworkimg.CoreBO")
public class CoreBO {

    @EJB
    private AdminUserDAO sysUserDAO;
    @EJB
    private AdminUserLogDAO sysUserLogDAO;

    public AdminUser findUserByUsername(String username) throws Exception {
        return sysUserDAO.findByUsername(username);
    }

    public void createSysUserLog(AdminUserLog log) throws Exception {
        sysUserLogDAO.create(log);
    }

    public List<AdminUserLog> findSysUserLogList(AdminUser user) throws Exception {
        return sysUserLogDAO.findSysUserLogList(user);
    }

}
