package com.xin.repository;

import com.xin.model.Hello;

import java.util.List;

/**
 * Author: Xin
 * Date: 14-5-4
 * Time: 下午1:59
 */
public interface HelloRepo {
    public void saveHello(Hello hello);
    public List<Hello> listHello();
    public Hello getHello(Integer helloId);
}
