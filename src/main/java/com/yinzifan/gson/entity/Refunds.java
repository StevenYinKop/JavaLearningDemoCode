package com.yinzifan.gson.entity;

import java.util.List;

/**
 * @author yinzf2
 * 2018/07/05	14:44:07
 */
public class Refunds {
    private String object;
    private String url;
    private boolean has_more;
    private List<String> data;
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isHas_more() {
        return has_more;
    }
    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }
    public List<String> getData() {
        return data;
    }
    public void setData(List<String> data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Refunds [object=" + object + ", url=" + url + ", has_more=" + has_more + ", data=" + data + "]";
    }
    
}
