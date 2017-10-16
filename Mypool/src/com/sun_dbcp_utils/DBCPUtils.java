package com.sun_dbcp_utils;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {

	//得到连接池
	private static DataSource dataSource;
	
	//获得数据库
	static {
		try {
			//加载properties文件,获得Properties对象
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp-config.properties");
			Properties prop = new Properties();
			prop.load(is);
			//通过工厂,创建连接池
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	//获得连接
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}
}
