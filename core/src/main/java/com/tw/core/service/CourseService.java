package com.tw.core.service;

import com.tw.core.dao.hibernateDao.CourseDao;
import com.tw.core.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/19/15.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public void insertCourse(Course course){
        courseDao.insertCourse(course);
    }

    public boolean isCourseExist(String name){
        return courseDao.getCourseByName(name);
    }

    public int getCourseIdByName(String name){
        return courseDao.getCourseIdByName(name);
    }

    public List<Course> getCoursesByCoachId(int coachId){

        return courseDao.getCoursesByCoachId(coachId);
    }
}