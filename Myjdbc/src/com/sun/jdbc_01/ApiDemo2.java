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
		 * �ͷ���Դ
		 * 
		 */
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		//ע������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			rs = st.executeQuery("select * from category");
			
			//��������
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
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
