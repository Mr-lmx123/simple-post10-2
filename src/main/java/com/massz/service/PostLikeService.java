package com.massz.service;

import com.massz.model.Post;
import com.massz.model.PostLike;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface PostLikeService {

    int insertPostLike(PostLike postLike);

    int deletePostLike(PostLike postLike);
}
