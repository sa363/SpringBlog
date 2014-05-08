package com.xin.web;

import com.xin.model.BlogConstant;
import com.xin.model.Posts;
import com.xin.model.User;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
                mav.setView(new RedirectView("admin/index"));
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
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView homeHandler(){
        return new ModelAndView("admin.home");
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

    @RequestMapping(value = "/new/post",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> savePosts(HttpServletRequest request){

        Map<String,Object> resultMap = new HashMap<String, Object>();

        User user = (User) request.getSession().getAttribute("user");
        Posts posts = new Posts();
        String categoryIdStr = request.getParameter("categoryId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Long categoryId = null;
        if(categoryIdStr != null && !categoryIdStr.equals("")){
            categoryId = Long.parseLong(categoryIdStr);

        }
        posts.setAuthorId(user.getUserId());

        if(categoryId != null){
            posts.setPostCategory(categoryId);
        }
        if(title != null){
            posts.setPostTitle(title);

        }
        if(content != null){
            posts.setPostContent(content);
        }
        posts.setPostDate(new Date());
        posts.setPostModified(new Date());

        Long id = this.springBlogService.savePosts(posts);

        resultMap.put("postId",id);
        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;
    }

    @RequestMapping(value = "/posts/{postId}",method = RequestMethod.GET)
    public ModelAndView getPost(@PathVariable Long postId,ModelAndView mav){
        Map<String,Object> model = new HashMap<String, Object>();
        Posts posts = this.springBlogService.findPostsById(postId);
        model.put("post",posts);
        mav.addObject(model);
        mav.setViewName("admin.posts.show");
        return mav;
    }

}
