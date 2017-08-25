package com.m.retrofit.model;

public class User {
    private String nm;
    private String cty;
    private String hse;
    private String yrs;

    public User(String nm, String cty, String hse, String yrs) {
        this.nm = nm;
        this.cty = cty;
        this.hse = hse;
        this.yrs = yrs;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getCty() {
        return cty;
    }

    public void setCty(String cty) {
        this.cty = cty;
    }

    public String getHse() {
        return hse;
    }

    public void setHse(String hse) {
        this.hse = hse;
    }

    public String getYrs() {
        return yrs;
    }

    public void setYrs(String yrs) {
        this.yrs = yrs;
    }
}
