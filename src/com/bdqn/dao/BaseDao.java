package com.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bdqn.utils.ConfigManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 数据库增删改查操作的公共方法
 * @author Administrator
 */
public abstract class BaseDao<T> {


	protected static Logger logger = Logger.getLogger(BaseDao.class);

	protected Connection conn;

	/**
	 * 查中需要用到的获得实体对象的方法，由具体的DaoImpl实现
	 * @param rs
	 * @return
	 */
	public abstract T getEntity(ResultSet rs);
	
	/**
	 * 操作数据库的增删改方法
	 * @param sql
	 * @param params
	 * @return 影响的行数
	 */
	public int executeUpdate(String sql, Object[] params) {
		PreparedStatement ps = null;
		try {
			//创建语句集对象
			ps = conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			logger.debug(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {

		}
		return -1;
	}

	/**
	 * 查数据并显示的方法
	 * @param sql
	 * @param params
	 * @return 对象集合
	 */
	public List<T> executeQuery(String sql, Object[] params){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			ps = conn.prepareStatement(sql);
			if (params!=null && params.length>0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			while(rs.next()){
				T t = getEntity(rs);
				list.add(t);
			}
			logger.debug(sql);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}finally{

		}
		return null;
	}

	/**
	 *
	 * @param sql
	 * @return
	 */
	public Integer executeQueryMaxId(String sql){
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			rs = conn.prepareStatement(sql).executeQuery();
			logger.debug(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}finally{

		}
		return null;
	}
}
