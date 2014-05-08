package com.xin.repository.impl;

import com.xin.model.Post;
import com.xin.repository.PostRepo;
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
public class PostsRepoImpl implements PostRepo {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Long save(Post posts) throws DataAccessException {

        Long id = posts.getPostId();

        if(id == null){
            id = (Long) this.getCurrentSession().save(posts);
        }else {
            this.getCurrentSession().update(posts);
        }

        return id;
    }

    @Override
    public Post find(Long id) throws DataAccessException {
        return (Post) this.getCurrentSession().get(Post.class, id);
    }

    @Override
    public Collection<Post> findAll() throws DataAccessException {
        return null;
    }
}
