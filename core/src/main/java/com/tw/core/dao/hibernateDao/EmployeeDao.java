package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.Employee;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
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

}
