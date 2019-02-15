package com.fineworkimg.ejb.facade;

import com.fineworkimg.core.ejb.bo.CoreBO;
import com.fineworkimg.core.ejb.entity.AdminUser;
import com.fineworkimg.core.ejb.entity.AdminUserLog;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Aekasit
 */
@Stateless
public class CoreFacade {

    @EJB
    private CoreBO coreBO;

    public AdminUser findUserByUsername(String username) throws Exception {
        return coreBO.findUserByUsername(username);
    }

    public void createSysUserLog(AdminUserLog log) throws Exception {
        coreBO.createSysUserLog(log);
    }

    public List<AdminUserLog> findSysUserLogList(AdminUser user) throws Exception {
        return coreBO.findSysUserLogList(user);
    }

}
