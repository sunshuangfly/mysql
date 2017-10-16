package com.sun_utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 等效 JdbcUtils，用于提供获得连接工具类
 */
public class C3P0Utils {
	
	//连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("itheima"); 
	
	/**
	 * 获得数据源(连接池)
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	
	/**
	 * 获得连接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		//将从连接池中获得连接
		return dataSource.getConnection();
	}
	
	

}
