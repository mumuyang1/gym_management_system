package com.tw.core.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yzli on 7/20/15.
 */
@Entity
@Table(name = "customers")
public class Customer {

    private int id;
    private String name;
    private Employee employee;
    private Set<Course>  courses  = new HashSet();

    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String name, Employee employee) {
        this.name = name;
        this.employee = employee;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "coach_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customers_courses", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
