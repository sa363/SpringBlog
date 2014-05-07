package com.xin.repository.impl;

import com.xin.model.Posts;
import com.xin.repository.PostsRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Author: Xin
 * Date: 14-5-7
 * Time: 下午3:23
 */
@Repository
public class PostsRepoImpl implements PostsRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Posts posts) throws DataAccessException {

        Long id = posts.getPostId();

        if(id == null){
            id = (Long) this.getCurrentSession().save(posts);
        }else {
            this.getCurrentSession().update(posts);
        }

        return id;
    }

    @Override
    public Posts find(Long id) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Posts> findAll() throws DataAccessException {
        return null;
    }
}
