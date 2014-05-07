package com.xin.web;

import com.xin.model.User;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Author: Xin
 * Date: 14-5-7
 * Time: 上午9:29
 */

@Controller
@SessionAttributes("user")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SpringBlogService springBlogService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("admin.login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processLogin(@RequestParam String name, @RequestParam String password){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin.login");
        User user = this.springBlogService.findUserByName(name);
        if(user != null){
            if(user.getPassword().equals(password.trim())){
                mav.addObject("user",user);
                mav.setViewName("admin.index");
            }

            return mav;
        }
        return mav;
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView indexHandler(HttpServletRequest request,ModelAndView mav){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user == null){
            mav.setView(new RedirectView("/admin"));
        }else{
            mav.setViewName("admin.index");
        }
        return mav;
    }
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public ModelAndView newHandler(){
        return new ModelAndView("admin.new");
    }
    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    public ModelAndView postsHandler(){
        return new ModelAndView("admin.posts");
    }
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public ModelAndView categoriesHandler(){
        return new ModelAndView("admin.categories");
    }
    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public ModelAndView commentsHandler(){
        return new ModelAndView("admin.comments");
    }

}
