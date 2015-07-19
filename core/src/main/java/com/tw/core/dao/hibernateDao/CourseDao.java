package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.Course;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yzli on 7/17/15.
 */
@Repository
public class CourseDao {

    public void insertCourse(Course course) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(course);
        session.getTransaction().commit();
    }

    public List<Course> getCoursesByCoachId(int coachId){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Course as course where employee.id=:coachId");
        query.setParameter("coachId", coachId);

        List<Course> courseList = query.list();

        session.getTransaction().commit();

        return courseList;
    }

    public static void main(String[] args){

        List<Course> courseList = new CourseDao().getCoursesByCoachId(1);

        System.out.println(courseList.get(0).getName()+"??");
        System.out.println(courseList.size() + "=================");

        System.out.println(courseList.get(1).getName());
    }

}
