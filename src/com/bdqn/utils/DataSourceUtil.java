package com.bdqn.utils;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 数据库连接与关闭的工具
 * @author Administrator
 */
public class DataSourceUtil {
	/**
	 * 私有化构造，防止实例化
	 */
	private DataSourceUtil(){}
	/**
	 * 通过JNDI连接池获取数据库连接对象
	 * @return 数据库连接对象
	 */
	public static Connection getConnectionJNDI(){
		Connection conn=null;
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/news");
			conn=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 通过database.properties文件获取数据库连接对象
	 * @return 连接对象
	 */
	public static Connection getConnection(){
		try {
			//加载驱动
			Class.forName(ConfigManager.getInstance().getString("jdbc.driver"));
			//获得连接
			return DriverManager.getConnection(ConfigManager.getInstance().getString("jdbc.url"),
					ConfigManager.getInstance().getString("jdbc.username"),
					ConfigManager.getInstance().getString("jdbc.password"));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关闭数据库所有连接
	 */
	public static void closeAllResource(Connection conn, Statement stmt, PreparedStatement ps,
								 ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
