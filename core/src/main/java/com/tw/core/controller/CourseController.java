package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by yzli on 7/21/15.
 */
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Course> getCourses() {

//        modelAndView.addObject("coachList", employeeService.getCoaches());

        return courseService.getCourses();
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ModelAndView getCoursesPage() {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("coursesManagement");
//        modelAndView.addObject("courseList", courseService.getCourses());
//        modelAndView.addObject("coachList", employeeService.getCoaches());
//
//        return modelAndView;
//    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView insertCourse(@RequestParam String courseName ,String coachId) {

        courseService.insertCourse(new Course(new Employee(Integer.parseInt(coachId)),courseName));

        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable int id, @RequestParam String name) {

        courseService.updateCourse(new Course(id, name, new Employee()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable int id) {

        courseService.deleteCourse(id);
    }
}
