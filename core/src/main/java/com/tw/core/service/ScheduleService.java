package com.tw.core.service;

import com.tw.core.dao.hibernateDao.ScheduleDao;
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

    public void insertSchedule(Schedule schedule){

        scheduleDao.insertSchedule(schedule);
    }

    public List<Schedule> getSchedules(){

        return scheduleDao.getSchedules();
    }

}
