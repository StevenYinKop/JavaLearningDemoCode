package com.yinzifan.gson.entity;

/**
 * @author yinzf2
 * 2018/07/05	14:46:45
 */
public class Wx {
    private String appId;
    private String partnerId;
    private String prepayId;
    private String nonceStr;
    private Long timeStamp;
    private String packageValue;
    private String sign;
    public String getAppId() {
        return appId;
    }
    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
    public String getPrepayId() {
        return prepayId;
    }
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }
    public String getNonceStr() {
        return nonceStr;
    }
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
    public Long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getPackageValue() {
        return packageValue;
    }
    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    @Override
    public String toString() {
        return "Wx [appId=" + appId + ", partnerId=" + partnerId + ", prepayId=" + prepayId + ", nonceStr=" + nonceStr + ", timeStamp=" + timeStamp
                + ", packageValue=" + packageValue + ", sign=" + sign + "]";
    }
}
