package com.xin.service.impl;

import com.xin.model.Hello;
import com.xin.repository.HelloRepo;
import com.xin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: Xin
 * Date: 14-5-4
 * Time: 下午2:02
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloRepo helloRepo;

    @Transactional
    @Override
    public void saveHello(Hello hello) {
        helloRepo.saveHello(hello);

    }

    @Transactional
    @Override
    public List<Hello> listHello() {
        return helloRepo.listHello();
    }

    @Transactional
    @Override
    public Hello getHello(Integer helloId) {

        return helloRepo.getHello(helloId);
    }
}
