package com.bdqn.test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestJDBC {

	@Test
	public void test(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		System.out.println(Class.class.getName());
		System.out.println(TestJDBC.class.getName());
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","admin","admin");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("");
			while(rs.next()){
				
			}
			
			System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭连接
		try {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (conn!=null) {
				conn.close();
				System.out.println("close success!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
