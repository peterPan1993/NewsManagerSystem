package com.bdqn.service.impl;

import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.entity.NewsUsers;
import com.bdqn.service.UserService;
import com.bdqn.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public NewsUsers login(String userName, String password) {
        Connection conn = null;
        NewsUsers user  = null;
        try {
            conn = DataSourceUtil.getConnection();
            //conn.setAutoCommit(false);//关闭自动提交，开启事务
            UserDao userDao=new UserDaoImpl(conn);
            user = userDao.getUserByUserName(userName);
            if (user != null){
                if (password.equals(user.getUpwd())){
                    return user;
                } else {
                    return new NewsUsers();
                }
            }
            //conn.commit();//成功，提交事务
        } catch (SQLException e) {
            if (conn != null){
                try {
                    conn.rollback();//异常回滚
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeAllResource(conn,null,null);
        }
        return user;
    }

    @Override
    public Integer register(NewsUsers user) {
        Connection conn = null;
        Integer result = null;
        try {
            conn = DataSourceUtil.getConnection();
            //conn.setAutoCommit(false);//关闭自动提交，开启事务
            UserDao userDao=new UserDaoImpl(conn);
            result = userDao.insertUser(user);
            //conn.commit();//成功，提交事务
        } catch (SQLException e) {
            if (conn != null){
                try {
                    conn.rollback();//异常回滚
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeAllResource(conn,null,null);
        }
        return result;
    }

}
