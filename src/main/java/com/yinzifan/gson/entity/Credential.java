package com.yinzifan.gson.entity;

/**
 * @author yinzf2
 * 2018/07/05	14:46:20
 */
public class Credential {
    private String object;
    private Wx wx;
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public Wx getWx() {
        return wx;
    }
    public void setWx(Wx wx) {
        this.wx = wx;
    }
    @Override
    public String toString() {
        return "Credential [object=" + object + ", wx=" + wx + "]";
    }
}
