package com.bdqn.dao.impl;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.UserDao;
import com.bdqn.entity.NewsUsers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao<NewsUsers> implements UserDao {

    public UserDaoImpl(Connection conn) {
        super.conn=conn;
    }

    @Override
    public NewsUsers getEntity(ResultSet rs) {
        NewsUsers user=null;
        if (rs!=null){
            try {
                int id=rs.getInt("uid");
                String userName = rs.getString("uname");
                String password = rs.getString("upwd");
                user = new NewsUsers(id,userName,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int insertUser(NewsUsers user) {
        String sql="insert into `news_users`(`uname`,`upwd`) values (?,?)";
        int i=0;
        i=super.executeUpdate(sql,new Object[]{user.getUname(),user.getUpwd()});
        return i;
    }

    @Override
    public NewsUsers getUserByUserName(String userName) throws SQLException {
        String sql="select * from `news_users` where uname=?";
        List<NewsUsers> list = super.executeQuery(sql,new Object[]{userName});
        if (list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
