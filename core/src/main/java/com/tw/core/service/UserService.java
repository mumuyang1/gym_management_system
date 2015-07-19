package com.tw.core.service;

import com.tw.core.dao.hibernateDao.UserDao;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/8/15.
 */
@Service
public class UserService {

    @Autowired private UserDao userDao;

    public List<User> getUsers() {

        return userDao.getUsers();
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

    public boolean login(String name, String password){

        return  userDao.login(name, password);
    }

    public int insertEmployee(Employee employee){

        return userDao.insertEmployee(employee);
    }

}
