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

    public Course() {
    }


    public Course(int id) {
        this.id = id;
    }

    public Course( Employee employee,String name) {
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
}
