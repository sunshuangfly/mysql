package com.sun.jdbc_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;


public class JdbcDemo_01 {

	@Test
	public void demo01() throws Exception {
		//查询数据库的所有分类信息
		
		//1 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2 获得链接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		
		//3 获得语句执行者
		Statement st = conn.createStatement();
		
		//4执行sql语句
		ResultSet rs = st.executeQuery("select * from category");
		
		//5处理结果集
		while(rs.next()) {
			//获得一行数据
			Integer cid = rs.getInt("cid");
			String cname = rs.getString("cname");
			
			System.out.println(cid+":"+cname);
		}
		
		//6释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
