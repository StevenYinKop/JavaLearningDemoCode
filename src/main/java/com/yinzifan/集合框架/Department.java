package com.yinzifan.集合框架;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String deptName;
    private Integer pid;
    private Integer delFlg;
    private List<Department> children;

    public Department(Integer id, String deptName, Integer pid, Integer delFlg) {
        this.id = id;
        this.deptName = deptName;
        this.pid = pid;
        this.delFlg = delFlg;
    }
}