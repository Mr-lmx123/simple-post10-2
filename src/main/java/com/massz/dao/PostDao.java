package com.massz.dao;

import com.massz.model.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao {
    int insertPost(Post post);

    List<Post> getPostList(Post post);

    @Delete("delete from post where post_id =#{postId} and user_id=#{userId}")
    int deletePost(Post post);

    @Update("update post set secret = #{secret} where post_id =#{postId} and user_id=#{userId}")
    int changePostSercet(Post post);
}
