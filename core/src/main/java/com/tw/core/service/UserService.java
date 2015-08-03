package com.tw.core.service;

import com.tw.core.dao.hibernateDao.GenericityInterface;
import com.tw.core.dao.hibernateDao.UserDao;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/8/15.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GenericityInterface<User> genericityInterface;

    public List<User> getUsers() {

        return userDao.getUsers();
//        return genericityInterface.getDataList(User.class);

    }

    public void deleteUserBy(int id) {

        userDao.deleteUserById(id);
    }

    public void insertUser(User user) {

        userDao.insertUser(user);
    }

    public void updateUser(User user) {

        userDao.updateUser(user);
    }

    public User getUserBy(int id) {

        return userDao.getUserById(id);
    }

    public boolean login(String name, String password) {

        return userDao.login(name, password);
    }
}
