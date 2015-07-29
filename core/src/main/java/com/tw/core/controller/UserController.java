package com.tw.core.controller;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import com.tw.core.utils.CookieUtil;
import com.tw.core.utils.HibernateAwareObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yzli on 7/12/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    //使用angular
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<User> showIndex() {

        System.out.println("需爱被警方把健康绝对服从地方好了ui");
        HibernateAwareObjectMapper mapper = new HibernateAwareObjectMapper();

        Hibernate4Module hbm = new Hibernate4Module();
        hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);

        mapper.registerModule(hbm);


        return userService.getUsers();
    }


    //    使用jsp
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public ModelAndView showIndex() {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("index");
//        modelAndView.addObject("userList", userService.getUsers());
//        return modelAndView;
//
//    }


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


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(HttpServletResponse response, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        CookieUtil.addCurrentURLToCookies(request, response);

        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView getLogin(@CookieValue("fromUrl") String fromUrl, @RequestParam String name, String password, HttpSession session, HttpServletResponse response) {

        if (userService.login(name, password)) {

            session.setAttribute("isLogin", true);

            if (fromUrl.equals("/users/sign-up")) {
                deleteFromUrlInCookie(response, fromUrl);

                return new ModelAndView("redirect:/employees");
            }

            deleteFromUrlInCookie(response, fromUrl);
            return new ModelAndView("redirect:" + fromUrl);

        } else {

            System.out.println("登录失败+++++++++++++++++++");
            return new ModelAndView("redirect:/login");
        }
    }

    private void deleteFromUrlInCookie(HttpServletResponse response, String toDeleteUrl) {

        Cookie cookie = new Cookie("url", toDeleteUrl);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
