package com.xin.service;

import com.xin.model.Hello;

import java.util.List;

/**
 * Author: Xin
 * Date: 14-5-4
 * Time: 下午2:01
 */
public interface HelloService {

    public void saveHello(Hello hello);
    public List<Hello> listHello();
    public Hello getHello(Integer helloId);
}
