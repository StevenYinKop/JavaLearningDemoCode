package com.yinzifan.reflect;

import java.io.Serializable;

public class ModifyHistoryItemPK implements Serializable {
    
    private static final long serialVersionUID = 8338642389361348077L;
    
    private Integer prjId;
    
    private Integer type;
    
    private Integer id;
    
    private Integer no;
    
    private String fieldName;
    
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
    
    @Override
    public String toString() {
        return "ModifyHistoryItemPK [prjId=" + prjId + ", type=" + type + ", id=" + id + ", no=" + no + ", fieldName=" + fieldName + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((no == null) ? 0 : no.hashCode());
        result = prime * result + ((prjId == null) ? 0 : prjId.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModifyHistoryItemPK other = (ModifyHistoryItemPK) obj;
        if (fieldName == null) {
            if (other.fieldName != null)
                return false;
        } else if (!fieldName.equals(other.fieldName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (no == null) {
            if (other.no != null)
                return false;
        } else if (!no.equals(other.no))
            return false;
        if (prjId == null) {
            if (other.prjId != null)
                return false;
        } else if (!prjId.equals(other.prjId))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    
}
