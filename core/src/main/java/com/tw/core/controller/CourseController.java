package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yzli on 7/21/15.
 */
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getCoursesPage(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("coursesManagement");
        modelAndView.addObject("courseList", courseService.getCourses());

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable int id,@RequestParam String name) {

        courseService.updateCourse(new Course(id, name, new Employee()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable int id) {

        courseService.deleteCourse(id);
    }
}
