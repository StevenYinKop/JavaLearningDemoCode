package com.yinzifan.reflect;

import java.io.Serializable;
import java.sql.Timestamp;

public class ModifyHistoryEntity implements Serializable {
    
    private static final long serialVersionUID = 8893957375754745696L;
    private Integer prjId;
    private Integer type;
    private Integer id;
    private Integer no;
    private String empId;
    private Timestamp time;
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
    
    public String getEmpId() {
        return empId;
    }
    
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    
    public Timestamp getTime() {
        return time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "ModifyHistoryEntity [prjId=" + prjId + ", type=" + type + ", id=" + id + ", no=" + no + ", empId=" + empId + ", time=" + time + "]";
    }
    
}
