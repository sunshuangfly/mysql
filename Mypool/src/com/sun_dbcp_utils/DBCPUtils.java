package com.sun_dbcp_utils;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {

	//�õ����ӳ�
	private static DataSource dataSource;
	
	//������ݿ�
	static {
		try {
			//����properties�ļ�,���Properties����
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcp-config.properties");
			Properties prop = new Properties();
			prop.load(is);
			//ͨ������,�������ӳ�
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	//�������
	public static Connection getConnection() throws Exception {
		return dataSource.getConnection();
	}
}
