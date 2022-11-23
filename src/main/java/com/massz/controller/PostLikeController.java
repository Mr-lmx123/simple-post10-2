package com.massz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.massz.model.*;
import com.massz.service.BarService;
import com.massz.service.PostImgService;
import com.massz.service.PostLikeService;
import com.massz.service.PostService;
import com.massz.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/post-like")
public class PostLikeController {
    @Autowired
    private PostLikeService postLikeService;

    // 点赞
    @GetMapping("addPostLike")
    @ResponseBody
    public ApiResult addPostLike(Integer postId,HttpSession session){
        Users users = (Users)session.getAttribute("userSession");
        PostLike postLike = new PostLike();
        postLike.setUserId(users.getUserId());
        postLike.setPostId(postId);

        int result = postLikeService.insertPostLike(postLike);
        ApiResult apiResult = new ApiResult();
        if(result == 0){
            apiResult.setCode(400);
            apiResult.setMessage("点赞失败");
        }
        return apiResult;
    }

    // 取消
    @GetMapping("deletePostLike")
    @ResponseBody
    public ApiResult deletePostLike(Integer postId,HttpSession session){
        Users users = (Users)session.getAttribute("userSession");
        PostLike postLike = new PostLike();
        postLike.setUserId(users.getUserId());
        postLike.setPostId(postId);

        int result = postLikeService.deletePostLike(postLike);
        ApiResult apiResult = new ApiResult();
        if(result == 0){
            apiResult.setCode(400);
            apiResult.setMessage("点赞失败");
        }
        return apiResult;
    }
}
