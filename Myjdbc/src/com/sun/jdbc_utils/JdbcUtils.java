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
			//ע������
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/*
	 * �������
	 */
	public static Connection getConnection() throws SQLException {
			//Ϊ��ֻע��һ������,��ע�������Ĺ��̷��ھ�̬�����
			/*//ע������
			Class.forName("driver");*/
			//�������
			Connection conn = DriverManager.getConnection(url, user, password);
			
			return conn;
	}
	
	/*
	 * �ͷ���Դ
	 */
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		//�����ͷ���Դ,������쳣,�ٷ�˵����������
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
