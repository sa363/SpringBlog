package com.xin.service;

import com.xin.model.Post;
import com.xin.model.User;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午10:03
 */
public interface SpringBlogService {


    Long saveUser(User user) throws DataAccessException;

    User findUserById(Long id) throws DataAccessException;

    User findUserByName(String name) throws DataAccessException;

    Collection<User> findAllUser() throws DataAccessException;

    Long savePost(Post post) throws DataAccessException;

    Post findPostById(Long id) throws DataAccessException;
}
