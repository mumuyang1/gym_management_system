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

    public List<Course> getCourses() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Course> courseList = session.createQuery("from Course").list();
        session.getTransaction().commit();

        return courseList;
    }



//    public void updateCustomerCourse(){
//
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//
//        session.save(course);
//
//    }

    public List<Course> getCoursesByCoachId(int coachId){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Course  where coach_id =:coachId");
        query.setParameter("coachId", coachId);

        List<Course> courseList = query.list();

        session.getTransaction().commit();

        return courseList;
    }

    public Course getCourse(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Course  where id =:id");
        query.setParameter("id", id);

        Course course = (Course)query.list().get(0);

        session.getTransaction().commit();

        return course;
    }


    public boolean getCourseByName(String name){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT count(*) FROM Course course where course.name = :name");

        query.setParameter("name", name);

        Long count = (Long)query.uniqueResult();

        session.getTransaction().commit();

        return count != 0;
    }

    public int getCourseIdByName(String name){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT course.id FROM Course course where course.name = :name");
        query.setParameter("name", name);

        int id = (Integer)query.list().get(0);

        session.getTransaction().commit();
        return id;
    }

    public void updateCourse(Course course){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("update Course c set c.name = :name where id = :id");
        query.setParameter("id", course.getId());
        query.setParameter("name", course.getName());
        query.executeUpdate();

        session.getTransaction().commit();
    }

    public void deleteCourse(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Course course = (Course) session.load(Course.class, id);
        session.delete(course);
        session.getTransaction().commit();
    }

    public int getCoachIdByCourseId(int courseId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT course.employee.id FROM Course course where course.id = :id");
        query.setParameter("id", courseId);

        int id = (Integer)query.list().get(0);

        session.getTransaction().commit();

        return id;
    }
}
