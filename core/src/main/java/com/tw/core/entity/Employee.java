package com.tw.core.entity;

/**
 * Created by yzli on 7/17/15.
 */
public class Employee {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String position;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, String email, String gender, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.position = position;
    }

    public Employee(String name, String email, String gender, String position) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
