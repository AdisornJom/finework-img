package com.fineworkimg.core.ejb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReportR105TO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "contractor_id")
    private Integer contractorId;
    @Column(name = "name")
    private String name;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "factory_net")
    private BigDecimal factoryNet;

    public Integer getContractorId() {
        return contractorId;
    }

    public void setContractorId(Integer contractorId) {
        this.contractorId = contractorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public BigDecimal getFactoryNet() {
        return factoryNet;
    }

    public void setFactoryNet(BigDecimal factoryNet) {
        this.factoryNet = factoryNet;
    }
   
   

}
