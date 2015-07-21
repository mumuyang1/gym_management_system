package com.tw.core.service;

import com.tw.core.dao.hibernateDao.CustomerDao;
import com.tw.core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/21/15.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void insertCustomer(Customer customer){
        customerDao.insertCustomer(customer);
    }

    public List<Customer> getCustomers(){
        return customerDao.getCustomers();
    }

    public void addCoachForCustomer(int coachId,int customerId){

        customerDao.addCoachForCustomer(coachId,customerId);
    }
}
