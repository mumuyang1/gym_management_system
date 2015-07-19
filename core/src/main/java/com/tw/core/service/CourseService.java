package com.tw.core.service;

import com.tw.core.dao.hibernateDao.CourseDao;
import com.tw.core.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
