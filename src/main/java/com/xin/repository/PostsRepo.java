package com.xin.repository;

import com.xin.model.Posts;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:44
 */
public interface PostsRepo {

    Long save(Posts posts) throws DataAccessException;

    Posts find(Long id) throws DataAccessException;

    Collection<Posts> findAll() throws DataAccessException;
}
