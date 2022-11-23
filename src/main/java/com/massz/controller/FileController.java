package com.massz.controller;

import com.massz.model.ApiResult;
import com.massz.model.Users;
import com.massz.service.UsersService;
import com.massz.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RequestMapping("file")
@Controller
public class FileController {
    @Autowired
    private UsersService usersService;


    // 跳转到文件上传页面
    @GetMapping("toFileUploadDemo")
    public String toFileUploadDemo(){
        return "fileUploadDemo";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("filename") List<MultipartFile> fileList){

        // 判断所上传文件是否存在
        if (!fileList.isEmpty() && fileList.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : fileList) {
                // 获取上传文件的原始名称
                String originalFilename = file.getOriginalFilename();
                // 设置上传文件的保存地址目录
                //    String dirPath = request.getServletContext().getRealPath("/upload/");
                String dirPath = "E:/upload/images/"; // 上传到其它目录，文件不会随tomcat重启消失
                File filePath = new File(dirPath);
                // 如果保存文件的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                // 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
                String newFilename = UUID.randomUUID() +
                        "_"+originalFilename;
                try {
                    // 使用MultipartFile接口的方法完成文件上传到指定位置
                    file.transferTo(new File(dirPath + newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return "my";
    }

    // 跳转到文件上传页面
    @GetMapping("toAvatarUpload")
    public String toAvatarUpload(){
        return "avatarUpload";
    }

    // 头像上传（单文件）
    @PostMapping("avatarUpload")
    public String avatarUpload(@RequestParam("filename") MultipartFile file, HttpSession session){

        if(!file.isEmpty()){
            // 获取上传文件的原始名称
            String originalFilename = file.getOriginalFilename();
            // 获取文件后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 设置上传文件的保存地址目录
            //    String dirPath = request.getServletContext().getRealPath("/upload/");
            String dirPath = "E:/upload/images/"; // 上传到其它目录，文件不会随tomcat重启消失
            File filePath = new File(dirPath);
            // 如果保存文件的地址不存在，就先创建目录
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            // 使用UUID重新命名上传的文件名称(uuid_原始文件名称)
            String newFilename = UUID.randomUUID() +suffix;
            try {
                // 使用MultipartFile接口的方法完成文件上传到指定位置
                file.transferTo(new File(dirPath + newFilename));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 更新users表中的头像字段，改为文件名
            Users users = (Users)session.getAttribute("userSession");
            users.setAvatar(newFilename);
            int result = usersService.updateUsersAvatar(users);
            if(result>0){
                // 更新session
                session.setAttribute("userSession",users);
            }
        }
        return "redirect:/user/toMy";
    }


    @PostMapping("avatarUpload2")
    @ResponseBody
    public ApiResult avatarUpload2(@RequestParam("filename") MultipartFile file,Users usersVO, HttpSession session){

        ApiResult apiResult = new ApiResult();

        String fileName = FileUtils.fileUploadSingle(file);
        if(fileName!=null){
            apiResult.setCode(200);
            // 更新users表中的头像字段，改为文件名
            Users users = (Users)session.getAttribute("userSession");
            users.setAvatar(fileName);
            int result = usersService.updateUsersAvatar(users);
            if(result>0){
                // 更新session
                session.setAttribute("userSession",users);
            }
        }else{
            apiResult.setCode(400);
            apiResult.setMessage("文件上传失败！");
        }

        return apiResult;
    }
}
