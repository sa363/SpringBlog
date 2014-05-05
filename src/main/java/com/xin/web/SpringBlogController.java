package com.xin.web;

import com.xin.model.User;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
