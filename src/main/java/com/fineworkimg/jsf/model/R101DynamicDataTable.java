/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.jsf.model;

import java.io.Serializable;

/**
 *
 * @author Adisorn.jo
 */
public class R101DynamicDataTable implements Serializable {

    private String name;
    private String api_bet125;
    private String api_bet168;
    private String api_topsport;
    private String api_m168;
    private String api_venetian;
    private String api_allbet;
    private String api_n2live;
    private String api_cockfight;
    private String api_racing_games;
    private String api_idnpoker;
    private String api_fishworld;
    private String api_sg_gaming;
    private String api_lotto;
    private String api_cq9;

    public R101DynamicDataTable(String name, String api_bet125, String api_bet168, String api_topsport, String api_m168, String api_venetian, String api_allbet,
            String api_n2live, String api_cockfight, String api_racing_games, String api_idnpoker, String api_fishworld,
            String api_sg_gaming, String api_lotto, String api_cq9) {
        this.name = name;
        this.api_bet125 = api_bet125;
        this.api_bet168 = api_bet168;
        this.api_topsport = api_topsport;
        this.api_m168 = api_m168;
        this.api_venetian = api_venetian;
        this.api_allbet = api_allbet;
        this.api_n2live = api_n2live;
        this.api_cockfight = api_cockfight;
        this.api_racing_games = api_racing_games;
        this.api_idnpoker = api_idnpoker;
        this.api_fishworld = api_fishworld;
        this.api_sg_gaming = api_sg_gaming;
        this.api_lotto = api_lotto;
        this.api_cq9 = api_cq9;
    }

    public String getName() {
        return name;
    }

    public String getApi_bet125() {
        return api_bet125;
    }

    public String getApi_bet168() {
        return api_bet168;
    }

    public String getApi_topsport() {
        return api_topsport;
    }

    public String getApi_venetian() {
        return api_venetian;
    }

    public String getApi_allbet() {
        return api_allbet;
    }

    public String getApi_n2live() {
        return api_n2live;
    }

    public String getApi_cockfight() {
        return api_cockfight;
    }

    public String getApi_racing_games() {
        return api_racing_games;
    }

    public String getApi_idnpoker() {
        return api_idnpoker;
    }

    public String getApi_fishworld() {
        return api_fishworld;
    }

    public String getApi_sg_gaming() {
        return api_sg_gaming;
    }

    public String getApi_lotto() {
        return api_lotto;
    }

    public String getApi_m168() {
        return api_m168;
    }
    
    public void setApi_m168(String api_m168) {
        this.api_m168 = api_m168;
}

    public String getApi_cq9() {
        return api_cq9;
}

    public void setApi_cq9(String api_cq9) {
        this.api_cq9 = api_cq9;
    }

}
