package com.xin.repository.impl;

import com.xin.model.User;
import com.xin.repository.UserRepo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:53
 */

@Repository
public class UserRepoImpl implements UserRepo{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(User user) throws DataAccessException {

        Long id = (Long) this.sessionFactory.getCurrentSession().save(user);

        return id;
    }

    @Override
    public User findById(Long id) throws DataAccessException {

        User user = (User) this.sessionFactory.getCurrentSession().get(User.class,id);

        return user;
    }

    @Override
    public Collection<User> findAll() throws DataAccessException {

        Query query =  this.sessionFactory.getCurrentSession().createQuery("from User");

        return  query.list();
    }
}
