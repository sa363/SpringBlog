package com.xin.service.impl;

import com.xin.model.User;
import com.xin.repository.UserRepo;
import com.xin.service.SpringBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午10:06
 */

@Service
public class SpringBlogServiceImpl implements SpringBlogService {

    @Autowired
    private UserRepo userRepo;


    @Transactional
    @Override
    public Long saveUser(User user) throws DataAccessException {
        return this.userRepo.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserById(Long id) throws DataAccessException {
        return this.userRepo.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUserByName(String name) throws DataAccessException {
        return this.userRepo.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<User> findAllUser() throws DataAccessException {
        return this.userRepo.findAll();
    }
}
