/*
 *  Copyright 2018 Liandisys Co. Ltd. All Rights Reserved.
 *  
 *  Licensed under the Liandi License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *        http://www.liandisys.com.cn/licenses/LICENSE-2.0
 *        
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.yinzifan.compare;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinzf2
 * 2018/07/24	13:49:08
 */
public class ObjectCompare {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("abc", 1, ""));
        list.add(new Person("qwe", 3, ""));
        list.add(new Person("abc", 2, ""));
        list.add(new Person("sss", 4, ""));
        list.sort((o1, o2) -> {
            if(o1.getName().equals(o2.getName())) {
                return 0;
            } else {
                return 1;
            }
        });
        System.out.println(list.toString());
    }
}

class Person {
    private String name;
    private int age;
    private String id;
    
    /**
     * @param name
     * @param age
     * @param id
     */
    public Person(String name, int age, String id) {
        super();
        this.name = name;
        this.age = age;
        this.id = id;
    }
    /**
     * 
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
    }
    
    
}
