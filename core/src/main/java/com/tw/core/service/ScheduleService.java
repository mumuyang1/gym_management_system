package com.tw.core.service;

import com.tw.core.dao.hibernateDao.ScheduleDao;
import com.tw.core.entity.Course;
import com.tw.core.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/19/15.
 */
@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private CourseService courseService;

    public void insertSchedule(Schedule schedule){

        scheduleDao.insertSchedule(schedule);
    }

    public List<Schedule> getSchedules(){

        return scheduleDao.getSchedules();
    }

    public boolean isTheDateAvailable(int coachId,String date){

        List<Course> courseList = courseService.getCoursesByCoachId(coachId);
        System.out.println(courseList.size());

        for (Course course : courseList){

            if(!scheduleDao.isTheDateAvailable(course.getId(),date)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){

        boolean courseList = new ScheduleService().isTheDateAvailable(1, "2015-07-30");
//        System.out.println(courseList.get(0).getName()+"===========");

        System.out.println(courseList+"===========");

    }

}
