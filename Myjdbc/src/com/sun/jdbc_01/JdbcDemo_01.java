package com.sun.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;


public class JdbcDemo_01 {

	@Test
	public void demo01() throws Exception {
		//��ѯ���ݿ�����з�����Ϣ
		
		//1 ע������
		Class.forName("com.mysql.jdbc.Driver");
		
		//2 �������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		
		//3 ������ִ����
		Statement st = conn.createStatement();
		
		//4ִ��sql���
		ResultSet rs = st.executeQuery("select * from category");
		
		//5��������
		while(rs.next()) {
			//���һ������
			Integer cid = rs.getInt("cid");
			String cname = rs.getString("cname");
			
			System.out.println(cid+":"+cname);
		}
		
		//6�ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}
}
