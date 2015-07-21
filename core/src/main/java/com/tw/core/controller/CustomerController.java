package com.tw.core.controller;

import com.tw.core.entity.Customer;
import com.tw.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yzli on 7/21/15.
 */
@RestController
@RequestMapping(value= "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getCoursesPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("customerManagement");
        modelAndView.addObject("customerList", customerService.getCustomers());

        return modelAndView;
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView insertCustomer(@RequestParam String name, HttpServletRequest request, HttpServletResponse response) {


        customerService.insertCustomer(new Customer(name));

        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int id,HttpServletRequest request, HttpServletResponse response) {

        customerService.deleteCustomer(id);

    }

}





















