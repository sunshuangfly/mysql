package com.sun_c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo_2 {

	@Test
	public void demo01() throws Exception {
		//获得连接池(数据源)
		//c3p0 jar包将自动加载'c3p0-config.xml'文件,并获得具体的配置信息,名称与配置文件named一直
		ComboPooledDataSource dataSource = new ComboPooledDataSource("sun");
		
		//获得连接
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		
	}
}
