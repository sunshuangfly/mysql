package com.sun.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ApiDemo2 {

	@Test
	public void demo01()  {
		/**
		 * 释放资源
		 * 
		 */
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		//注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			rs = st.executeQuery("select * from category");
			
			//处理结果集
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
