package com.massz.service.impl;

import com.massz.dao.PostDao;
import com.massz.dao.PostImgDao;
import com.massz.dao.UsersDao;
import com.massz.model.Post;
import com.massz.model.Users;
import com.massz.service.PostService;
import com.massz.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private PostImgDao postImgDao;

    @Override
    public int insertPost(Post post) {
        return postDao.insertPost(post);
    }

    @Override
    public List<Post> getPostList(Post post) {
        return postDao.getPostList(post);
    }

    @Override
    @Transactional
    public int deletePost(Post post) {

        int result = postDao.deletePost(post);
        if(result>0){
            postImgDao.deletePostImg(post.getPostId());
        }

        return result;
    }

    @Override
    public int changePostSercet(Post post) {
        return postDao.changePostSercet(post);
    }
}
