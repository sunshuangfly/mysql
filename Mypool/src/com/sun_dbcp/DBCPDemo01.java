package com.sun_dbcp;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBCPDemo01 {

	@Test 
	public void demo1() throws Exception {
		//获得连接池
		BasicDataSource dataSource = new BasicDataSource();
		
		//设置基本项
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		//获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
