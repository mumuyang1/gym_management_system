package com.tw.core.controller;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yzli on 7/18/15.
 */
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getEmployeePage(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String user = (String) session.getAttribute("user");

//        if (user == "login") {
        modelAndView.setViewName("employeeManagement");
        modelAndView.addObject("userList", userService.getUsers());


        return modelAndView;
//        } else {
//            modelAndView.setViewName("login");
//            CookieUtil.addCurrentURLToCookies(request, response);
//            return modelAndView;
//        }
    }
}
