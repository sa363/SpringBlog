package com.xin.repository;

import com.xin.model.Comments;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:49
 */
public interface CommentsRepo {

    Long save(Comments comments) throws DataAccessException;

    Comments find(Long id) throws DataAccessException;

    Collection<Comments> findAll() throws DataAccessException;

}
