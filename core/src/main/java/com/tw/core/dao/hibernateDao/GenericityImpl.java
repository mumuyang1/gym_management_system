package com.tw.core.dao.hibernateDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yzli on 8/3/15.
 */
@Repository
@EnableTransactionManagement
@Transactional

public class GenericityImpl<T> implements GenericityInterface<T> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<T> getDataList(Class<T> tClass) {

        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(tClass);
        List<T> list = criteria.list();

//        String s = tClass.getName().substring(19);
//        List<T> list = session.createQuery("from " + s).list();

        return list;
    }

    @Override
    public void insertData(T t) {

        Session session = sessionFactory.getCurrentSession();
        session.save(t);
    }

    @Override
    public void deleteData(T t) {

        Session session = sessionFactory.getCurrentSession();

        session.delete(t);
    }

    @Override
    public void updateData(T t) {

        Session session = sessionFactory.getCurrentSession();
        session.update(t);
    }
}
