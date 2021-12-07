package com.yinzifan.集合框架;

import com.beust.jcommander.internal.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapDemo {
    public static void main(String[] args) {
        new HashMapDemo().getDepartments();
    }


    public List<Department> getDepartments() {
        // 获取所有部门信息
        List<Department> flatDepartmentList = Lists.newArrayList(new Department(1, "A ", -1, 0),
                new Department(2, "AB", 1, 0),
                new Department(3, "AC", 1, 0),
                new Department(4, "AD", 1, 0),
                new Department(5, "AE", 2, 0),
                new Department(6, "AF", 2, 0),
                new Department(7, "AG", 3, 0),
                new Department(8, "AH", 3, 0),
                new Department(9, "AI", 3, 0),
                new Department(10, "AJ", 5, 0));
        // 按照部门pid对部门分组
        Map<Integer, Department> departmentIdMap = flatDepartmentList.stream().collect(Collectors.toMap(Department::getId, v -> v));
        Map<Integer, List<Department>> departmentGroupByParentId = flatDepartmentList.stream().collect(Collectors.groupingBy(Department::getPid));
        // 将分组后的部门信息组装到原部门的children中
        departmentIdMap.forEach((id, dept) -> {
            List<Department> childrenList = departmentGroupByParentId.get(id);
            if (CollectionUtils.isEmpty(childrenList)) {
                return;
            }
            dept.setChildren(childrenList);
        });
        // 删除pid != -1的部门信息
        return flatDepartmentList.stream().filter(dept -> dept.getPid() == -1).collect(Collectors.toList());
    }

}
