package com.xin.web;

import com.xin.model.Hello;
import com.xin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Xin
 * Date: 14-5-4
 * Time: 上午11:27
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;


    @RequestMapping("/")
    public String indexHandler(){
        return "index";
    }


    @RequestMapping("/hello")
    public String helloHandler(){


        Hello hello = new Hello();
        hello.setName("hello");
        hello.setRemarks("world");
        helloService.saveHello(hello);


        return "hello";
    }


    @RequestMapping("/hellos")
    public ModelAndView listHello(){
        Map<String,Object> model = new HashMap<String,Object>();
        ModelAndView mav = new ModelAndView();
        model.put("hellos",helloService.listHello());
        mav.addObject(model);
        mav.setViewName("hellolist");
        return mav;
    }
    @RequestMapping("/hello/{helloId}")
    public @ResponseBody Hello getHello(@PathVariable("helloId") Integer helloId){

        return helloService.getHello(helloId);

    }
}
