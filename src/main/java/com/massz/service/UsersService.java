package com.massz.service;

import com.massz.model.Users;

public interface UsersService {
    // 根据用户名查询用户信息
    Users findUsersByUserName(String userName);
    // 新增
    int insertUsers(Users users);
    // 修改头像
    int updateUsersAvatar(Users users);

    // 用户信息
    Users findUserInfo(Integer userId);
}
