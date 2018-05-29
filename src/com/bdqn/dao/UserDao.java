package com.bdqn.dao;

import com.bdqn.entity.NewsUsers;

import java.sql.SQLException;

public interface UserDao {

    int insertUser(NewsUsers user) throws SQLException;
    NewsUsers getUserByUserName(String userName) throws SQLException;

}
