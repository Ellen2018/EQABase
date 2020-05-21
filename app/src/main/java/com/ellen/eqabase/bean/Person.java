package com.ellen.eqabase.bean;

import com.ellen.dhcsqlitelibrary.table.reflection.Primarykey;

public class Person {

    @Primarykey
    private long id;
    private String name;
    private short age;

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

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
