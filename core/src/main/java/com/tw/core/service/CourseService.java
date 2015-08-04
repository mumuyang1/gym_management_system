package com.tw.core.service;

import com.tw.core.dao.hibernateDao.CourseDao;
import com.tw.core.dao.hibernateDao.GenericityInterface;
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

    @Autowired
    private GenericityInterface<Course> genericityInterface;

    public void insertCourse(Course course){
        genericityInterface.insertData(course);
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

    public List<Course> getCourses(){
        return genericityInterface.getDataList(Course.class);
    }

    public Course getCourse(int id){
        return courseDao.getCourse(id);
    }

    public void updateCourse(Course course){
        genericityInterface.updateData(course);
    }

    public void deleteCourse(int id){
        genericityInterface.deleteData(new Course(id));
    }

    public int getCoachIdByCourseId(int courseId){

        return courseDao.getCoachIdByCourseId(courseId);
    }
}
