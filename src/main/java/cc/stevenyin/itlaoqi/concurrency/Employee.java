package cc.stevenyin.itlaoqi.concurrency;

import java.util.TreeSet;

public class Employee {
    private String name;
    private Integer age;
    private Department department;

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("stevenyin");
        employee.setAge(26);
        Department department = new Department();
        department.setDname("开发部");
        employee.setDepartment(department);
        employee.say("阿巴阿巴阿巴");
        TreeSet<Employee> treeSet = new TreeSet<>();
        treeSet.add(employee);
        System.out.println(treeSet);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void say(String str) {
        System.out.println(this.name + "说：" + str);
    }
}

class Department {
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
