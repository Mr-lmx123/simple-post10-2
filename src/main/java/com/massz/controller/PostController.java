package com.massz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.massz.model.*;
import com.massz.service.BarService;
import com.massz.service.PostImgService;
import com.massz.service.PostService;
import com.massz.service.UsersService;
import com.massz.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostImgService postImgService;
    @Autowired
    private BarService barService;


    @RequestMapping("/toPublish")
    public String toPublish(Model model)
    {
        List<Bar> barList = barService.getBarAll();
        model.addAttribute("barList",barList);
        return "post/publish";
    }

    // 发布
    @PostMapping("publish")
    @ResponseBody
    public ApiResult publish(@RequestParam("filename") List<MultipartFile> fileList, Post postVo, HttpSession session){
        Users users = (Users)session.getAttribute("userSession");
        ApiResult apiResult = new ApiResult();
        // 创建一个帖子
        Post post = new Post();
        post.setPostTitle(postVo.getPostTitle());
        post.setContent(postVo.getContent());
        post.setUserId(users.getUserId());
        post.setBarId(postVo.getBarId());
        int result = postService.insertPost(post);

        // 保存图片
        List<String> fileNameList = FileUtils.fileUploadBatch(fileList);
        // 添加帖子图片表
        for (String picName:fileNameList) {
            PostImg postImg = new PostImg();
            postImg.setPicName(picName);
            postImg.setPostId(post.getPostId());
            postImgService.insertPostImg(postImg);
        }

        return apiResult;
    }

    @RequestMapping("/toPostList")
    public String toPostList()
    {
        return "post/postList";
    }

    // 获取我的帖子列表
    @GetMapping("getPostList")
    @ResponseBody
    public ApiResult getPostList(Integer pageNum,Integer pageSize, HttpSession session){
        Users users = (Users)session.getAttribute("userSession");
        Post post = new Post();
        post.setUserId(users.getUserId());

        PageHelper.startPage(pageNum,pageSize); // pageNum当前页码，pageSize每页条数
        List<Post> list = postService.getPostList(post);
        PageInfo pageInfo = new PageInfo(list);

        ApiResult apiResult = new ApiResult();
        apiResult.setData(pageInfo);
        return apiResult;
    }

    // 删除帖子
    @GetMapping("deletePost")
    @ResponseBody
    public ApiResult deletePost(Integer postId,HttpSession session){
        Users users = (Users)session.getAttribute("userSession");
        Post post = new Post();
        post.setUserId(users.getUserId());
        post.setPostId(postId);


        int result = postService.deletePost(post);
        ApiResult apiResult = new ApiResult();
        if(result == 0){
            apiResult.setCode(400);
            apiResult.setMessage("删除失败");
        }
        return apiResult;
    }

    // 更改帖子公开或私密
    @GetMapping("changePostSercet")
    @ResponseBody
    public ApiResult changePostSercet(Integer postId,Integer secret, HttpSession session){
        Users users = (Users)session.getAttribute("userSession");
        Post post = new Post();
        post.setUserId(users.getUserId());
        post.setPostId(postId);
        post.setSecret(secret);

        int result = postService.changePostSercet(post);
        ApiResult apiResult = new ApiResult();
        if(result == 0){
            apiResult.setCode(400);
            apiResult.setMessage("设置失败");
        }
        return apiResult;
    }

}
