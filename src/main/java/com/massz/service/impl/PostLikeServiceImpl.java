package com.massz.service.impl;

import com.massz.dao.PostDao;
import com.massz.dao.PostImgDao;
import com.massz.dao.PostLikeDao;
import com.massz.model.Post;
import com.massz.model.PostLike;
import com.massz.service.PostLikeService;
import com.massz.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostLikeServiceImpl implements PostLikeService {

    @Autowired
    private PostLikeDao postLikeDao;


    @Override
    public int insertPostLike(PostLike postLike) {
        return postLikeDao.insertPostLike(postLike);
    }

    @Override
    public int deletePostLike(PostLike postLike) {
        return postLikeDao.deletePostLike(postLike);
    }
}
