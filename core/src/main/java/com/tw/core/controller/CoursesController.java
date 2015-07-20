package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.service.CourseService;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yzli on 7/19/15.
 */
@RestController
@RequestMapping(value = "/courses")
public class CoursesController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getCoursesPage(HttpSession session,HttpServletRequest request,HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView();
        String user = (String) session.getAttribute("user");

//        if (user == "login") {
            modelAndView.setViewName("coursesManagement");
            modelAndView.addObject("scheduleList", scheduleService.getSchedules());
//            System.out.println("=========================");
//            System.out.println(scheduleService.getSchedules().get(0).getDate());
//            System.out.println(scheduleService.getSchedules().get(0).getCourse().getName());
//            System.out.println(scheduleService.getSchedules().get(0).getCourse().getEmployee().getName());

            modelAndView.addObject("coachList", employeeService.getCoaches());

        return modelAndView;
//        } else {
//            modelAndView.setViewName("login");
//            CookieUtil.addCurrentURLToCookies(request, response);
//            return modelAndView;
//        }
    }

    @RequestMapping(value = "/creation",method = RequestMethod.POST)
    public ModelAndView insertCourse(@RequestParam String name,String date,String coachId, HttpSession session,HttpServletRequest request,HttpServletResponse response){

        Employee employee = new Employee(Integer.parseInt(coachId));
        Course course = new Course(employee,name);
        Schedule schedule = new Schedule(course,date);

        if (scheduleService.isTheDateAvailable(Integer.parseInt(coachId),date)){

            if(!courseService.isCourseExist(name)){
                courseService.insertCourse(course);
                scheduleService.insertSchedule(schedule);

            }else {
                scheduleService.insertSchedule(new Schedule(new Course(courseService.getCourseIdByName(name)),date));
            }
            return new ModelAndView("redirect:/courses");
        }else {
            return new ModelAndView("dateNotAvailableError");
        }
    }
}
