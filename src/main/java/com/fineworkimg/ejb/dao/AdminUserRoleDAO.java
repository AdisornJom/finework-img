/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.ejb.dao;

import com.fineworkimg.core.util.Persistence;
import com.fineworkimg.core.ejb.entity.AdminUserRole;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aekasit
 */
@Stateless
public class AdminUserRoleDAO extends AbstractDAO<AdminUserRole> {
    @PersistenceContext(unitName =Persistence.finework)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminUserRoleDAO() {
        super(AdminUserRole.class);
    }
    
}
