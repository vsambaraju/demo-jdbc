package com.example.demojdbc;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;


public class Student {

    private long id;
    private String name;
    private String school;

    public Student() {
    }

    public Student(long id, String name, String school) {
        this.id = id;
        this.name = name;
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
