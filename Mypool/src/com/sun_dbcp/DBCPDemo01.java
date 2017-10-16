package com.sun_dbcp;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBCPDemo01 {

	@Test 
	public void demo1() throws Exception {
		//������ӳ�
		BasicDataSource dataSource = new BasicDataSource();
		
		//���û�����
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//�������
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
