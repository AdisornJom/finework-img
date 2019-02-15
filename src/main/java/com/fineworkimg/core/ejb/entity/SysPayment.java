/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.ejb.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "sys_payment")
@NamedQueries({
    @NamedQuery(name = "SysPayment.findAll", query = "SELECT s FROM SysPayment s")})
public class SysPayment implements Serializable , Comparator<SysPayment> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Size(max = 50)
    @Column(name = "payment_type")
    private String paymentType;
    @Size(max = 50)
    @Column(name = "documentno")
    private String documentno;
    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Size(max = 500)
    @Column(name = "remark")
    private String remark;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payment_total")
    private Double paymentTotal;
    @Column(name = "payment_vat")
    private Double paymentVat;
    @Column(name = "payment_total_price")
    private Double paymentTotalPrice;
    @Column(name = "real_total_price")
    private Double realTotalPrice;
    @Column(name = "bill_date_last")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billDateLast;
    @Column(name = "created_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDt;
    @Size(max = 45)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "modified_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDt;
    @Size(max = 45)
    @Column(name = "modified_by")
    private String modifiedBy;
    
    //@OneToMany(mappedBy = "paymentId")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paymentId", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<SysPaymentDetail> sysPaymentDetailList;
    
    @JoinColumn(name = "workunit_id", referencedColumnName = "workunit_id")
    @ManyToOne
    private SysWorkunit workunitId;

    public SysPayment() {
    }

    public SysPayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public Double getPaymentVat() {
        return paymentVat;
    }

    public void setPaymentVat(Double paymentVat) {
        this.paymentVat = paymentVat;
    }

    public Double getPaymentTotalPrice() {
        return paymentTotalPrice;
    }

    public void setPaymentTotalPrice(Double paymentTotalPrice) {
        this.paymentTotalPrice = paymentTotalPrice;
    }

    public Double getRealTotalPrice() {
        return realTotalPrice;
    }

    public void setRealTotalPrice(Double realTotalPrice) {
        this.realTotalPrice = realTotalPrice;
    }

    public Date getBillDateLast() {
        return billDateLast;
    }

    public void setBillDateLast(Date billDateLast) {
        this.billDateLast = billDateLast;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<SysPaymentDetail> getSysPaymentDetailList() {
        return sysPaymentDetailList;
    }

    public void setSysPaymentDetailList(List<SysPaymentDetail> sysPaymentDetailList) {
        this.sysPaymentDetailList = sysPaymentDetailList;
    }

    public SysWorkunit getWorkunitId() {
        return workunitId;
    }

    public void setWorkunitId(SysWorkunit workunitId) {
        this.workunitId = workunitId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysPayment)) {
            return false;
        }
        SysPayment other = (SysPayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fineworkimg.core.ejb.entity.SysPayment[ paymentId=" + paymentId + " ]";
    }
    
    @Override
    public int compare(SysPayment o1, SysPayment o2) {
       return o2.getPaymentId().compareTo(o1.getPaymentId());
    }
}
