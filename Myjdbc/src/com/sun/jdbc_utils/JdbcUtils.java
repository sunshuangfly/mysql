package com.sun.jdbc_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mydb";
	private static String user = "root";
	private static String password = "root";
	
	static{
		try {
			//注册驱动
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * 获得连接
	 */
	public static Connection getConnection() throws SQLException {
			//为了只注册一次驱动,将注册驱动的过程放在静态代码块
			/*//注册驱动
			Class.forName("driver");*/
			//获得连接
			Connection conn = DriverManager.getConnection(url, user, password);
			
			return conn;
	}
	
	/*
	 * 释放资源
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		//倒着释放资源,如果有异常,官方说明不做处理
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
