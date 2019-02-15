/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.ejb.dao;


import com.fineworkimg.core.ejb.entity.SysCreatejob;
import com.fineworkimg.core.ejb.entity.SysForeman;
import com.fineworkimg.core.ejb.entity.SysWorkunit;
import com.fineworkimg.core.util.Persistence;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class SysCreateJobDAO extends AbstractDAO<SysCreatejob> {

    @PersistenceContext(unitName = Persistence.finework)
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SysCreateJobDAO() {
        super(SysCreatejob.class);
    }
    
    public List<SysCreatejob> findSysCreatejobListByCriteria(SysForeman foremanId,String documentno,SysWorkunit workunitId,Integer status,Date startDate, Date toDate) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM SysCreatejob m ");
        sb.append("where 1=1 ");
        
        if (null != foremanId) {
            sb.append("and m.foremanId.foremanId = :foremanId ");
        }

        if (null != documentno && documentno.length() > 0) {
            sb.append("and m.documentNo like :documentno ");
        }
                
        if (null != workunitId) {
           sb.append("and m.workunitId.workunitId = :workunitId ");
        }
        
        if (null != status){
            sb.append("and m.status = :status ");
        }
         
        if (null != startDate) {
            sb.append("and m.jobStartdate >= :startDate ");
        }
        if (null != toDate) {
            sb.append("and m.jobStartdate <= :toDate ");
        }
        
        sb.append("ORDER BY m.jobId DESC ");

        Query q = em.createQuery(sb.toString());
        if (null != foremanId) {
            q.setParameter("foremanId", foremanId.getForemanId());
        }
        if (null != documentno && documentno.length() > 0) {
            q.setParameter("documentno", "%" + documentno + "%");
        }
        if (null != workunitId) {
           q.setParameter("workunitId", workunitId.getWorkunitId());
        }
        if (null != status){
            q.setParameter("status", status);
        }
        if (null != startDate) {
            q.setParameter("startDate", startDate);
        }
        if (null != toDate) {
            q.setParameter("toDate", toDate);
        }

        return q.getResultList();
    }
}
