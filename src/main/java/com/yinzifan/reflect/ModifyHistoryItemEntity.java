package com.yinzifan.reflect;

import java.io.Serializable;

public class ModifyHistoryItemEntity implements Serializable {
    
    private static final long serialVersionUID = 617774260894498677L;
    private Integer prjId;
    private Integer type;
    private Integer id;
    private Integer no;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private String oldValueJP;
    private String newValueJP;
    
    public Integer getPrjId() {
        return prjId;
    }
    
    public void setPrjId(Integer prjId) {
        this.prjId = prjId;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getNo() {
        return no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public String getOldValue() {
        return oldValue;
    }
    
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
    
    public String getNewValue() {
        return newValue;
    }
    
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
    
    public String getOldValueJP() {
        return oldValueJP;
    }
    
    public void setOldValueJP(String oldValueJP) {
        this.oldValueJP = oldValueJP;
    }
    
    public String getNewValueJP() {
        return newValueJP;
    }
    
    public void setNewValueJP(String newValueJP) {
        this.newValueJP = newValueJP;
    }
    
    @Override
    public String toString() {
        return "ModifyHistoryItemEntity [prjId=" + prjId + ", type=" + type + ", id=" + id + ", no=" + no + ", fieldName=" + fieldName + ", oldValue="
                + oldValue + ", newValue=" + newValue + ", oldValueJP=" + oldValueJP + ", newValueJP=" + newValueJP + "]";
    }
    
}
