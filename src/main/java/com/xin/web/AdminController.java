package com.xin.web;

import com.xin.model.BlogConstant;
import com.xin.model.Category;
import com.xin.model.Post;
import com.xin.model.User;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;


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

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("posts",this.springBlogService.findAllPost());

        return new ModelAndView("admin.posts",model);
    }
    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public ModelAndView categoriesHandler(){

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("categories",this.springBlogService.findAllCategory());

        return new ModelAndView("admin.categories",model);
    }
    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public ModelAndView commentsHandler(){
        return new ModelAndView("admin.comments");
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> savePost(HttpServletRequest request){

        Map<String,Object> resultMap = new HashMap<String, Object>();

        User user = (User) request.getSession().getAttribute("user");
        Post post = new Post();
        post.setCommentStatus(BlogConstant.POST_COMMETNS_STATUS_OPEN);
        String categoryIdStr = request.getParameter("categoryId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String postIdStr = request.getParameter("postId");
        String postStatusStr = request.getParameter("postStatus");
        String commentStatusStr = request.getParameter("commentStatus");

        if(postIdStr != null && !postIdStr.equals("")){
            Long postId = Long.parseLong(postIdStr);
            if(postId != null){
                post.setPostId(postId);

            }
        }

        Long categoryId = null;
        if(categoryIdStr != null && !categoryIdStr.equals("")){
            categoryId = Long.parseLong(categoryIdStr);

        }
        post.setAuthorId(user.getUserId());

        if(categoryId != null){
            post.setCategoryId(categoryId);
        }
        if(title != null){
            post.setPostTitle(title);

        }
        if(content != null){
            post.setPostContent(content);
        }
        if(postStatusStr != null && !postStatusStr.equals("")){
            post.setPostStatus(Integer.parseInt(postStatusStr));
        }
        if(commentStatusStr != null && !commentStatusStr.equals("")){
            post.setCommentStatus(Integer.parseInt(commentStatusStr));
        }
        post.setPostDate(new Date());
        post.setPostModifiedDate(new Date());

        Long id = this.springBlogService.savePost(post);

        resultMap.put("postId",id);
        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;
    }

    @RequestMapping(value = "/posts/{postId}",method = RequestMethod.GET)
    public ModelAndView findPost(@PathVariable Long postId){

        Map<String,Object> model = new HashMap<String, Object>();

        Post post = this.springBlogService.findPostById(postId);
        User author = this.springBlogService.findUserById(post.getAuthorId());
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String postDate = dateformat.format(post.getPostDate());


        model.put("post",post);
        model.put("author",author.getUserName());
        model.put("postDate",postDate);

        return new ModelAndView("admin.posts.show",model);
    }

    @RequestMapping(value = "/post/{postId}",method = RequestMethod.DELETE)
    public @ResponseBody Map<String,Object>  deletePost(@PathVariable Long postId){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        this.springBlogService.deletePost(postId);
        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;

    }

    @RequestMapping(value = "/posts",method = RequestMethod.DELETE)
    public @ResponseBody void batchDeletePost(@RequestBody MultiValueMap<String, String> body){


        Map<String, String> params = body.toSingleValueMap();
        String idsStr = params.get("ids");
        String[] idsArr = idsStr.split(",");

        List<Long> ids = new ArrayList<Long>();
        for(int i = 0; i < idsArr.length; i++){
            ids.add(Long.parseLong(idsArr[i]));
        }

    }


    @RequestMapping(value = "/post/{postId}",method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object>  updatePost(@PathVariable Long postId, @RequestBody MultiValueMap<String, String> body, HttpServletResponse response){

        Map<String, Object> resultMap = new HashMap<String, Object>();

        Post post = this.springBlogService.findPostById(postId);
        Map<String, String> params = body.toSingleValueMap();

        String commentStatusStr = params.get("commentStatus");

        if(commentStatusStr != null && !commentStatusStr.equals("")){
            post.setCommentStatus(Integer.parseInt(commentStatusStr));
        }

        this.springBlogService.savePost(post);

        resultMap.put("returnCode", BlogConstant.RETURN_CODE_SUCC);

        return resultMap;
    }

    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public @ResponseBody Map<String , Object> saveCategory(@RequestParam String categoryName){
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Category category = new Category();
        category.setCatName(categoryName);

        this.springBlogService.saveCategory(category);

        return resultMap;
    }



}
