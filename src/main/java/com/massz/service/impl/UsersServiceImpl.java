package com.massz.service.impl;

import com.massz.dao.UsersDao;
import com.massz.model.Users;
import com.massz.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public Users findUsersByUserName(String userName) {
        return usersDao.findUsersByUserName(userName);
    }

    @Override
    public int insertUsers(Users users) {
        return usersDao.insertUsers(users);
    }

    @Override
    public int updateUsersAvatar(Users users) {
        return usersDao.updateUsersAvatar(users);
    }

    @Override
    public Users findUserInfo(Integer userId) {
        return usersDao.findUserInfo(userId);
    }
}
