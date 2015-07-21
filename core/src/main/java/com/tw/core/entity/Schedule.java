package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by yzli on 7/19/15.
 */

@Entity
@Table(name="schedules")
public class Schedule {

    private int id;
    private Course course;
    private String date;
    private Customer customer;

    public Schedule() {
    }

    public Schedule(int id) {
        this.id = id;
    }

    public Schedule(Course course, String date) {
        this.course = course;
        this.date = date;
    }

    public Schedule(int id, Course course, String date) {
        this.id = id;
        this.course = course;
        this.date = date;
    }

    public Schedule(Course course, String date, Customer customer) {
        this.course = course;
        this.date = date;
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Column(name="date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @OneToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
