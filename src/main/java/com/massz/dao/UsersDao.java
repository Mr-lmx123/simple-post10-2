package com.massz.dao;

import com.massz.model.Users;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {
    // 根据用户名查询用户信息
    Users findUsersByUserName(String userName);
    // 新增
    int insertUsers(Users users);
    // 修改头像
    @Update("update users set avatar=#{avatar} where user_id = #{userId}")
    int updateUsersAvatar(Users users);

    Users findUserInfo(Integer userId);
}
