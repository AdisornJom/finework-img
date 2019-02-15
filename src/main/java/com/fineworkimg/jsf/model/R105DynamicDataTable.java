/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.jsf.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Adisorn.jo
 */
public class R105DynamicDataTable  implements Serializable{

    private String api_name;
    private BigDecimal trunover;
    private BigDecimal winloss;
    private String method;

    public R105DynamicDataTable(String api_name, BigDecimal trunover, BigDecimal winloss, String method) {
        this.api_name = api_name;
        this.trunover = trunover;
        this.winloss= winloss;
        this.method= method;
    }

    public String getApi_name() {
        return api_name;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }

    public BigDecimal getTrunover() {
        return trunover;
    }

    public void setTrunover(BigDecimal trunover) {
        this.trunover = trunover;
    }

    public BigDecimal getWinloss() {
        return winloss;
    }

    public void setWinloss(BigDecimal winloss) {
        this.winloss = winloss;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
