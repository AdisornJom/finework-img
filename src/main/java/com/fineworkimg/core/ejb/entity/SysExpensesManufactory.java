/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.ejb.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "sys_expenses_manufactory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysExpensesManufactory.findAll", query = "SELECT s FROM SysExpensesManufactory s")})
public class SysExpensesManufactory implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "expenses_id")
    private Integer expensesId;
    @Size(max = 50)
    @Column(name = "document_no")
    private String documentNo;
    @Column(name = "expenses_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expensesDate;
    @Column(name = "amount")
    private Double amount;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Column(name = "expenses_status")
    private Integer expensesStatus;
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
    
    //@OneToMany(mappedBy = "expensesId")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expensesId", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<SysExpensesManufactoryDetail> sysExpensesManufactoryDetailList;
    
   // @OneToMany(mappedBy = "expensesId")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expensesId", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<SysPaymentManufactoryExpdetail> sysPaymentManufactoryExpdetailList;
    
    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne
    private SysContractor contractorId;
    
    @JoinColumn(name = "factory_id", referencedColumnName = "factory_id")
    @ManyToOne
    private SysManufactory factoryId;
    
    @JoinColumn(name = "deduction_id", referencedColumnName = "deduction_id")
    @ManyToOne
    private SysExpensesManufactoryDeduction deductionId;
    
    
    @Transient
    private Double total_expenses;

    public SysExpensesManufactory() {
    }

    public SysExpensesManufactory(Integer expensesId) {
        this.expensesId = expensesId;
    }

    public Integer getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Integer expensesId) {
        this.expensesId = expensesId;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public Date getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(Date expensesDate) {
        this.expensesDate = expensesDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getExpensesStatus() {
        return expensesStatus;
    }

    public void setExpensesStatus(Integer expensesStatus) {
        this.expensesStatus = expensesStatus;
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

    @XmlTransient
    public List<SysExpensesManufactoryDetail> getSysExpensesManufactoryDetailList() {
        return sysExpensesManufactoryDetailList;
    }

    public void setSysExpensesManufactoryDetailList(List<SysExpensesManufactoryDetail> sysExpensesManufactoryDetailList) {
        this.sysExpensesManufactoryDetailList = sysExpensesManufactoryDetailList;
    }

    public SysContractor getContractorId() {
        return contractorId;
    }

    public void setContractorId(SysContractor contractorId) {
        this.contractorId = contractorId;
    }

    public SysManufactory getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(SysManufactory factoryId) {
        this.factoryId = factoryId;
    }

    public SysExpensesManufactoryDeduction getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(SysExpensesManufactoryDeduction deductionId) {
        this.deductionId = deductionId;
    }

    public Double getTotal_expenses() {
        return total_expenses;
    }

    public void setTotal_expenses(Double total_expenses) {
        this.total_expenses = total_expenses;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expensesId != null ? expensesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysExpensesManufactory)) {
            return false;
        }
        SysExpensesManufactory other = (SysExpensesManufactory) object;
        if ((this.expensesId == null && other.expensesId != null) || (this.expensesId != null && !this.expensesId.equals(other.expensesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fineworkimg.core.ejb.entity.SysExpensesManufactory[ expensesId=" + expensesId + " ]";
    }

    @XmlTransient
    public List<SysPaymentManufactoryExpdetail> getSysPaymentManufactoryExpdetailList() {
        return sysPaymentManufactoryExpdetailList;
    }

    public void setSysPaymentManufactoryExpdetailList(List<SysPaymentManufactoryExpdetail> sysPaymentManufactoryExpdetailList) {
        this.sysPaymentManufactoryExpdetailList = sysPaymentManufactoryExpdetailList;
    }
    
}
