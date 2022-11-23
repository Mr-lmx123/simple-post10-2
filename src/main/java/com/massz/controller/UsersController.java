package com.massz.controller;

import com.massz.model.ApiResult;
import com.massz.model.Users;
import com.massz.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLOutput;

@Controller
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UsersService usersService;
    /*
        去登录页面
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    /*
     * 登录
     */
    @PostMapping("login")
    @ResponseBody
    public ApiResult login(Users usersVo,HttpSession session){
        System.out.println("userName:"+usersVo.getUserName());
        System.out.println("password:"+usersVo.getPassword());

        Users users = usersService.findUsersByUserName(usersVo.getUserName());

        ApiResult apiResult = new ApiResult();
        if(users == null){
            apiResult.setCode(400);
            apiResult.setMessage("用户名不存在！");
        }else{
            if(users.getPassword().equals(usersVo.getPassword())){
                // 把用户信息放入session中
                session.setAttribute("userSession",users);

                apiResult.setCode(200);
                apiResult.setMessage("登录成功");
            }else{
                apiResult.setCode(400);
                apiResult.setMessage("密码错误");
            }
        }

        return apiResult;
    }

    // 我的
    @RequestMapping("toMy")
    public String toMy(){
        return "my";
    }

    // 跳转到注册页面
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    // 用户注册
    @PostMapping("register")
    @ResponseBody
    public ApiResult register(Users usersVo){
        int result = usersService.insertUsers(usersVo);
        ApiResult apiResult = new ApiResult();
        if(result>0){
            apiResult.setCode(200);
        }else{
            apiResult.setCode(400);
            apiResult.setMessage("注册失败");
        }
        return apiResult;
    }

    // 判断用户是否已存在
    @GetMapping("userNameExist")
    @ResponseBody
    public ApiResult userNameExist(String userName){
        Users users = usersService.findUsersByUserName(userName);
        ApiResult apiResult = new ApiResult();
        if(users == null){
            apiResult.setCode(200);
            apiResult.setData(0);
        }else{
            apiResult.setCode(200);
            apiResult.setData(1);
        }
        return apiResult;
    }

    // 去设置页面
    @RequestMapping("toSet")
    public String toSet(){
        return "set";
    }

    // 退出
    @RequestMapping("logout")
    public String logout(HttpSession session){
        // 销毁回话
        session.invalidate();
        // 重定向到登录页面
        return "redirect:/user/toLogin";
    }

    // 查询用户信息
    @GetMapping("findUserInfo")
    @ResponseBody
    public ApiResult findUserInfo(HttpSession session){
        Users users = (Users)session.getAttribute("userSession");

        Users usersInfo = usersService.findUserInfo(users.getUserId());
        ApiResult apiResult = new ApiResult();
        apiResult.setData(usersInfo);
        return apiResult;
    }
}
