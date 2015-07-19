package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yzli on 7/19/15.
 */
@Repository
public class ScheduleDao {

    public void insertSchedule(Schedule schedule) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(schedule);
        session.getTransaction().commit();
    }

    public List<Schedule> getSchedules(){

        Session session =  HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();//获取事务

        List<Schedule> scheduleList = session.createQuery("from Schedule").list();
        session.getTransaction().commit();

        return scheduleList;
    }

    public List<Schedule> getScheduleByCoach(int coachId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Schedule as schedule where schedule.coachId=:coachId");

        query.setParameter("position", "教练");

        List<Employee> employeeList = query.list();
        session.getTransaction().commit();

        return employeeList;
    }
}
