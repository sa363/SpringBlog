package com.xin.repository;

import com.xin.model.Post;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:44
 */
public interface PostRepo {

    Long save(Post posts) throws DataAccessException;

    Post find(Long id) throws DataAccessException;

    Collection<Post> findAll() throws DataAccessException;
}
