package com.tw.core.dao.hibernateDao;

import com.tw.core.utils.HibernateUtil;
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

//        Criteria criteria = session.createCriteria(tClass);
//        List<T> list = criteria.list();

        System.out.println(tClass.getName());

        String s = tClass.getName().substring(19);
        System.out.println("--------------------------------");
        System.out.println(s);
        System.out.println("--------------------------------");
        List<T> list = session.createQuery("from " + s).list();

        session.getTransaction().commit();
        return list;
    }

    @Override
    public void insertData(T t) {

    }

    @Override
    public void deleteData(T t) {

    }

    @Override
    public void updateData(T t) {

    }
}
