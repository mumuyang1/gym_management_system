package com.tw.core.entity;

/**
 * Created by yzli on 7/7/15.
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private Employee employee;

    public User() {
    }

    public User(int id, String userName, String password, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }

    public User(String userName, String password, Employee employee) {
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
