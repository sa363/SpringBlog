package com.xin.repository;

import com.xin.model.Categories;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-5
 * Time: 上午9:51
 */
public interface CategoriesRepo {


    Long save(Categories categories) throws DataAccessException;

    Categories find(Long id) throws DataAccessException;

    Collection<Categories> findAll() throws DataAccessException;

}
