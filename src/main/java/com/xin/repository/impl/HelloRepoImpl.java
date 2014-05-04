package com.xin.repository.impl;

import com.xin.model.Hello;
import com.xin.repository.HelloRepo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: Xin
 * Date: 14-5-4
 * Time: 下午2:01
 */
@Repository
public class HelloRepoImpl implements HelloRepo {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveHello(Hello hello) {
        sessionFactory.getCurrentSession().save(hello);

    }

    @Override
    public List<Hello> listHello() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hello ");
        List<Hello> helloList = query.list();
        return helloList;
    }

    @Override
    public Hello getHello(Integer helloId) {
        return (Hello) sessionFactory.getCurrentSession().get(Hello.class,helloId);
    }
}
