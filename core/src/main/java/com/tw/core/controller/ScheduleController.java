package com.tw.core.controller;

import com.tw.core.entity.Course;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import com.tw.core.service.CourseService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yzli on 7/19/15.
 */
@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getSchedulePage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("schedulesManagement");
        modelAndView.addObject("scheduleList", scheduleService.getSchedules());
        modelAndView.addObject("coachList", employeeService.getCoaches());
        modelAndView.addObject("customerList", customerService.getCustomers());
        modelAndView.addObject("courseList", courseService.getCourses());

        return modelAndView;
    }

    @RequestMapping(value = "/creation", method = RequestMethod.POST)
    public ModelAndView insertCourse(@RequestParam String courseId, String date) {

        int coachId = courseService.getCoachIdByCourseId(Integer.parseInt(courseId));
        if (scheduleService.isTheDateAvailable(coachId, date)) {

            Employee employee = new Employee(coachId);
            scheduleService.insertSchedule(new Schedule(new Course(Integer.parseInt(courseId),employee), date));

            return new ModelAndView("redirect:/schedules");

        } else {
            return new ModelAndView("dateNotAvailableError");
        }
    }

    @RequestMapping(value = "/creation/private", method = RequestMethod.POST)
    public ModelAndView insertPrivateCourse(@RequestParam String date, String coachId, String customerId) {

        if (scheduleService.isTheDateAvailable(Integer.parseInt(coachId), date)) {

            if (!courseService.isCourseExist("私教课")) {
                Employee employee = new Employee(Integer.parseInt(coachId));
                Course course = new Course(employee, "私教课");
                Schedule schedule = new Schedule(course, date, new Customer(Integer.parseInt(customerId)));

                courseService.insertCourse(course);
                scheduleService.insertSchedule(schedule);

            } else {
                scheduleService.insertSchedule(new Schedule(new Course(courseService.getCourseIdByName("私教课")), date, new Customer(Integer.parseInt(customerId))));
            }
            customerService.addCoachForCustomer(Integer.parseInt(coachId), Integer.parseInt(customerId));

            return new ModelAndView("redirect:/schedules");
        } else {
            return new ModelAndView("dateNotAvailableError");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable int id) {

        scheduleService.deleteScheduleById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getUserById(@PathVariable int id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("updateSchedule");
        modelAndView.addObject("schedule", scheduleService.getScheduleById(id));
        modelAndView.addObject("coachList", employeeService.getCoaches());

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable int id, @RequestParam String date, String courseId, String coachId) {


        if (scheduleService.isTheDateAvailable(Integer.parseInt(coachId), date)) {
            Course course = new Course(Integer.parseInt(courseId));

            Schedule schedule = new Schedule(id, course, date);
            scheduleService.updateSchedule(schedule);
            return null;
        } else {
            return "timeNotAvailable";
        }
    }
}
