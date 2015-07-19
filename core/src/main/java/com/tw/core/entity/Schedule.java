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

    public Schedule() {
    }

    public Schedule(Course course, String date) {
        this.course = course;
        this.date = date;
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
}
