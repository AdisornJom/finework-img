/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.ejb.dao;


import com.fineworkimg.core.ejb.entity.SysCreatejobDetail;
import com.fineworkimg.core.util.Persistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class SysCreateJobDetailDAO extends AbstractDAO<SysCreatejobDetail> {

    @PersistenceContext(unitName = Persistence.finework)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SysCreateJobDetailDAO() {
        super(SysCreatejobDetail.class);
    }
    
    public List<SysCreatejobDetail> findSysCreatejobDetailListByJobI1d(Integer jobId) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM SysCreatejobDetail m ");
        sb.append("where 1=1 ");
        
        if (null != jobId) {
            sb.append("and m.jobId.jobId = :jobId ");
        }
        
        sb.append("ORDER BY m.id DESC ");

        Query q = em.createQuery(sb.toString());
        if (null != jobId) {
            q.setParameter("jobId", jobId);
        }

        return q.getResultList();
    }
}
