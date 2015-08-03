package com.tw.core.dao.hibernateDao;

import java.util.List;

/**
 * Created by yzli on 8/3/15.
 */
public interface GenericityInterface<T> {

    List<T> getDataList(Class<T> tClass);
    void insertData(T t);
    void deleteData(T t);
    void updateData(T t);
}
