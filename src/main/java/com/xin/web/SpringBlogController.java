package com.xin.web;

import com.sun.deploy.net.HttpResponse;
import com.xin.model.User;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午10:10
 */

@Controller
public class SpringBlogController {

    @Autowired
    private SpringBlogService springBlogService;

    @RequestMapping("/user")
    public String userHandler(){
        User user = new User();
        user.setUserName("hello");
        user.setUserEmail("hello@163.com");
        this.springBlogService.saveUser(user);
        return "user";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        String login = null;
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String processLogin(@RequestParam("name") String name,@RequestParam("password") String password){

        Map<String, Object> model = new HashMap<String, Object>();

        User user = this.springBlogService.findUserByName(name);
        if(user != null){
            user.getPassword().equals(password.trim());
            model.put("user",user);
            return "admin";
        }

        return "redirect:/admin";
    }
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(){
        String admin = null;
        return "admin";
    }


}
