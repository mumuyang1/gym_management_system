package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by yzli on 7/19/15.
 */

@Repository
public class EmployeeDao {

    public List<Employee> getEmployees(){

       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Employee> employeeList = session.createQuery("from Employee").list();

        return employeeList;
    }

    public List<Employee> getCoaches(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Employee as employee where employee.position=:position");

        query.setParameter("position", "教练");

        List<Employee> employeeList = query.list();
        session.getTransaction().commit();

        return employeeList;
    }

    public static void main(String[] args){
//        Course course = new Course(1);
//        Schedule schedule = new Schedule(course,new Date());
//        new ScheduleDao().insertSchedule(schedule);

        List<Employee> scheduleList = new EmployeeDao().getCoaches();
        System.out.println(scheduleList.get(0).getName()+"??");
        System.out.println(scheduleList.size()+"=================");

        System.out.println(scheduleList.get(1).getName());
    }
}
