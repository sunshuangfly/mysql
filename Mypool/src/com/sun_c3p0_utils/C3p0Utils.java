package com.sun_c3p0_utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 这个C3p0Utils 等效于之前的 JdbcUtils,用于提供连接,获得连接的工具类
 * 
 */
public class C3p0Utils {
	
	//连接池
	private static ComboPooledDataSource dataSource;
	
	//获得连接池(数据源)
	public static DataSource getDataSource() {
		return dataSource;
	}

	//获得连接
	public static Connection getConnection () throws Exception {
		//从连接池中获得连接
		return dataSource.getConnection();
	}
}
