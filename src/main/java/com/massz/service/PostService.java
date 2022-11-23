package com.massz.service;

import com.massz.model.Post;
import com.massz.model.Users;

import java.util.List;

public interface PostService {
    int insertPost(Post post);

    List<Post> getPostList(Post post);

    int deletePost(Post post);

    int changePostSercet(Post post);
}
