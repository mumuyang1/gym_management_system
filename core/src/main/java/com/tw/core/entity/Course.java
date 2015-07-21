package com.tw.core.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yzli on 7/17/15.
 */
@Entity
@Table(name="courses")
public class Course {

    private int id;
    private String name;
    private Employee employee;
    private Set<Schedule>schedules = new HashSet<Schedule>();
    private Set<Customer> customers  = new HashSet();

    public Course() {
    }


    public Course(int id) {
        this.id = id;
    }

    public Course( Employee employee,String name) {
        this.name = name;
        this.employee = employee;
    }

    public Course(int id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne()
    @JoinColumn(name="coach_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(mappedBy="course")
    public Set<Schedule> getSchedules() {

        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules)
    {
        this.schedules = schedules;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
