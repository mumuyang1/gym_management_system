package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.Customer;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NavigableMap;

/**
 * Created by yzli on 7/21/15.
 */

@Repository
public class CustomerDao {

    public void insertCustomer(Customer customer){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(customer);

        session.getTransaction().commit();
    }

    public List<Customer> getCustomers(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> customerList =  query.list();

        session.getTransaction().commit();

        return customerList;
    }

    public void addCoachForCustomer(int coachId,int customerId){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("update Customer c set c.employee.id = :coachId where id = :customerId");
        query.setParameter("coachId", coachId);
        query.setParameter("customerId",customerId);
        query.executeUpdate();

        session.getTransaction().commit();
    }

    public static void main(String[] args){

        new CustomerDao().insertCustomer(new Customer("顾客小明"));
    }
}
