package com.bdqn.dao.impl;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.UserDao;
import com.bdqn.entity.NewsUsers;

import java.sql.ResultSet;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public Object getEntity(ResultSet rs) {
        return null;
    }

    @Override
    public int addUser(NewsUsers user) {
        String sql="insert into `news_users`(`uname`,`upwd`) values (?,?)";
        int i=0;
        i=super.executeUpdate(sql,new Object[]{user.getUname(),user.getUpwd()});
        return i;
    }

    @Override
    public NewsUsers insert(String userName) {
        return null;
    }
}
