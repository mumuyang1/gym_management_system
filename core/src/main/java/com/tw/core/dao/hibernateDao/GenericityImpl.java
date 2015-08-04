package com.tw.core.dao.hibernateDao;

import com.tw.core.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yzli on 8/3/15.
 */
@Repository
public class GenericityImpl<T> implements GenericityInterface<T> {

    @Override
    public List<T> getDataList(Class<T> tClass) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(tClass);
        List<T> list = criteria.list();

//        String s = tClass.getName().substring(19);
//        List<T> list = session.createQuery("from " + s).list();

        session.getTransaction().commit();
        return list;
    }

    @Override
    public void insertData(T t) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(t);

        session.getTransaction().commit();
    }

    @Override
    public void deleteData(T t) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.delete(t);

        session.getTransaction().commit();
    }

    @Override
    public void updateData(T t) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.update(t);

        session.getTransaction().commit();
    }
}