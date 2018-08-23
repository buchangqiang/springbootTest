package com.myspringboot.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 测试类
 */
public class TestUser {
    @JSONField(serialize = false)
    private long id;
    private String name;
    private int age;

    public TestUser(){}
    public TestUser(String name,int age) {
       this.name=name;
       this.age=age;
    }
    public TestUser(long id,String name,int age){
        this(name,age);
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("name=%s,age=%d",getName(),getAge());
    }
}
