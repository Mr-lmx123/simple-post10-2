package com.massz.dao;

import com.massz.model.Post;
import com.massz.model.PostLike;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeDao {

    @Insert("insert post_like values(#{userId},#{postId})")
    int insertPostLike(PostLike postLike);

    @Delete("delete from post_like where user_id=#{userId} and post_id = #{postId}")
    int deletePostLike(PostLike postLike);
}
