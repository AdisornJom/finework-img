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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Aekasit
 */
@Entity
@Table(name = "core_config")
@NamedQueries({
    @NamedQuery(name = "Config.findAll", query = "SELECT c FROM Config c")})
public class Config implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "field")
    private String field;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "data")
    private String data;

    public Config() {
    }

    public Config(String field) {
        this.field = field;
    }

    public Config(String field, String value) {
        this.field = field;
        this.data = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (field != null ? field.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Config)) {
            return false;
        }
        Config other = (Config) object;
        if ((this.field == null && other.field != null) || (this.field != null && !this.field.equals(other.field))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onebet.core.ejb.entity.Config[ field=" + field + " ]";
    }

}
