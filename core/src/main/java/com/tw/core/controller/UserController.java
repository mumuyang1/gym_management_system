package com.tw.core.controller;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yzli on 7/12/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showIndex() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("userList", userService.getUsers());
        return modelAndView;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") int id) {

        userService.deleteUserBy(id);
    }

    @RequestMapping(value = "/creation", method = RequestMethod.GET)
    public ModelAndView getInsertPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("insertUser");
        return modelAndView;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public ModelAndView signUp() {

        return new ModelAndView("register");

    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ModelAndView signUp(@RequestParam String userName, String password, String gender, String name, String email, String position) {

        Employee employee = new Employee(name, email, gender, position);

        User user = new User(userName, password, employee);

        userService.insertUser(user);

        return new ModelAndView("redirect:/courses");

    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView getHomePage() {

        return new ModelAndView("homePage");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable int id, @RequestParam String userName, String password, String employeeId,
                           String name, String gender,
                           String email, String position) {


        userService.updateUser(new User(id, userName, password, new Employee(Integer.parseInt(employeeId), name, email, gender, position)));
    }

}
