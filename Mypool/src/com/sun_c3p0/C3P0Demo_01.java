package com.sun_c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo_01 {

	@Test
	public void demo01() throws Exception {
		//获得连接池(数据源)
		//c3p0 jar包将自动加载'c3p0-config.xml'文件,并获得具体的配置信息,名称与配置文件named一直
		ComboPooledDataSource dataSource = new ComboPooledDataSource("sun");
		
		
		/*ComboPooledDataSource datasource = new ComboPooledDataSource();
		
		//设置基本项
		datasource.setDriverClass("com.mysql.jdbc.Driver");
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
		datasource.setUser("root");
		datasource.setPassword("root");
		
		//其他项
		//初始化连接池中连接个数
		datasource.setInitialPoolSize(5);
		
		//连接池最少有2个
		datasource.setMinPoolSize(2);
		//连接池中最多只能有10个连接,根据需求和电脑性能配置
		//如果有第11个需求连接,只能等待,因为我能设置最大承载就是10
		datasource.setMaxPoolSize(10);
		//最大空闲时间
		datasource.setMaxIdleTime(60);*/
		
		//获得连接
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		
	}
}
