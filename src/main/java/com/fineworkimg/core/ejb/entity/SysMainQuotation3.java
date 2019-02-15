/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.ejb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "sys_main_quotation3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMainQuotation3.findAll", query = "SELECT s FROM SysMainQuotation3 s")})
public class SysMainQuotation3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "quotation3_id")
    private Integer quotation3Id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "seq")
    private Double seq;
    @Size(max = 500)
    @Column(name = "detail")
    private String detail;
    @Column(name = "volume")
    private Double volume;
    @Size(max = 100)
    @Column(name = "unit")
    private String unit;
    @Column(name = "value_unit")
    private Double valueUnit;
    @Column(name = "install_unit")
    private Double installUnit;
    @Column(name = "amount")
    private Double amount;
    @JoinColumn(name = "quotation_id", referencedColumnName = "quotation_id")
    @ManyToOne
    private SysMainQuotation quotationId;

    public SysMainQuotation3() {
    }

    public SysMainQuotation3(Integer quotation3Id) {
        this.quotation3Id = quotation3Id;
    }

    public Integer getQuotation3Id() {
        return quotation3Id;
    }

    public void setQuotation3Id(Integer quotation3Id) {
        this.quotation3Id = quotation3Id;
    }

    public Double getSeq() {
        return seq;
    }

    public void setSeq(Double seq) {
        this.seq = seq;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(Double valueUnit) {
        this.valueUnit = valueUnit;
    }

    public Double getInstallUnit() {
        return installUnit;
    }

    public void setInstallUnit(Double installUnit) {
        this.installUnit = installUnit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SysMainQuotation getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(SysMainQuotation quotationId) {
        this.quotationId = quotationId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quotation3Id != null ? quotation3Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMainQuotation3)) {
            return false;
        }
        SysMainQuotation3 other = (SysMainQuotation3) object;
        if ((this.quotation3Id == null && other.quotation3Id != null) || (this.quotation3Id != null && !this.quotation3Id.equals(other.quotation3Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fineworkimg.core.ejb.entity.SysMainQuotation3[ quotation3Id=" + quotation3Id + " ]";
    }
    
}
