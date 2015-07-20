package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.Course;
import com.tw.core.entity.Schedule;
import com.tw.core.entity.User;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
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

    public List<Schedule> getSchedules() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();//获取事务

        List<Schedule> scheduleList = session.createQuery("from Schedule").list();
        session.getTransaction().commit();

        return scheduleList;
    }

    public void deleteScheduleById(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Schedule schedule = (Schedule) session.load(Schedule.class, id);
        session.delete(schedule);

        session.getTransaction().commit();
    }

    public boolean isTheDateAvailable(int courseId, String date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("select count(*) from Schedule  where course.id=:courseId and date = :date");

        query.setParameter("courseId", courseId);
        query.setParameter("date", date);

        Long count = (Long) query.uniqueResult();
        session.getTransaction().commit();

        return count == 0;
    }
}
