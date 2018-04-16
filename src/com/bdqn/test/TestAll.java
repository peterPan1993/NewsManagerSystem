package com.bdqn.test;

import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.entity.NewsUsers;

public class TestAll {

    public static void main(String[] args) {
        UserDao us = new UserDaoImpl();
        NewsUsers user = new NewsUsers();
        user.setUname("test1");
        user.setUpwd("123456");
        System.out.println(us.addUser(user));

    }



}
