package com.bdqn.dao;

import com.bdqn.entity.NewsUsers;

public interface UserDao {

    int addUser(NewsUsers user);
    NewsUsers insert(String userName);

}
