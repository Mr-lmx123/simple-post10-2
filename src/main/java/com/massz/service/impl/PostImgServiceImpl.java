package com.massz.service.impl;

import com.massz.dao.PostDao;
import com.massz.dao.PostImgDao;
import com.massz.model.Post;
import com.massz.model.PostImg;
import com.massz.service.PostImgService;
import com.massz.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostImgServiceImpl implements PostImgService {

    @Autowired
    private PostImgDao postImgDao;

    @Override
    public int insertPostImg(PostImg postImg) {
        return postImgDao.insertPostImg(postImg);
    }
}
