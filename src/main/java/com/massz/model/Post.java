package com.massz.model;

import java.util.List;

public class Post {

    private Integer postId;
    private String postTitle;
    private String content;
    private Integer barId;
    private Integer userId;
    private String createTime;

    private String barName;
    private Integer secret;

    private Integer likeNum; // 点赞数
    private Integer myLike; // 我是否点赞  0-未点赞，1-已点赞

    private List<PostImg> postImgList;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public Integer getSecret() {
        return secret;
    }

    public void setSecret(Integer secret) {
        this.secret = secret;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getMyLike() {
        return myLike;
    }

    public void setMyLike(Integer myLike) {
        this.myLike = myLike;
    }

    public List<PostImg> getPostImgList() {
        return postImgList;
    }

    public void setPostImgList(List<PostImg> postImgList) {
        this.postImgList = postImgList;
    }
}
