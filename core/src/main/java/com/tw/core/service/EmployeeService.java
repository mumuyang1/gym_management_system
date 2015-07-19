package com.tw.core.service;

import com.tw.core.dao.hibernateDao.EmployeeDao;
import com.tw.core.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/19/15.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees(){
        return  employeeDao.getEmployees();
    }

    public List<Employee> getCoaches(){
        return employeeDao.getCoaches();
    }
}
