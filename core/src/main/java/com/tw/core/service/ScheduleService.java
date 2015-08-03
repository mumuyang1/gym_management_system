package com.tw.core.service;

import com.tw.core.dao.hibernateDao.GenericityInterface;
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

    @Autowired
    private GenericityInterface<Schedule> genericityInterface;

    public void insertSchedule(Schedule schedule){

        genericityInterface.insertData(schedule);
    }

    public List<Schedule> getSchedules(){

        return  genericityInterface.getDataList(Schedule.class);
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

    public void deleteScheduleById(int id){
        scheduleDao.deleteScheduleById(id);
    }

    public static void main(String[] args){

        boolean courseList = new ScheduleService().isTheDateAvailable(1, "2015-07-30");
//        System.out.println(courseList.get(0).getName()+"===========");

        System.out.println(courseList + "===========");

    }

    public Schedule getScheduleById(int id){
        return scheduleDao.getScheduleById(id);
    }

    public void updateSchedule(Schedule schedule){

        scheduleDao.updateSchedule(schedule);

    }



}
