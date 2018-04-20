package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.entity.NewsUsers;
import com.bdqn.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public NewsUsers login(String userName, String password) {

        return new NewsUsers(0,userName,password);
    }
}
