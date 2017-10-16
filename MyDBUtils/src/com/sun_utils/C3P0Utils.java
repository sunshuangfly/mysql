package com.sun_utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ��Ч JdbcUtils�������ṩ������ӹ�����
 */
public class C3P0Utils {
	
	//���ӳ�
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("itheima"); 
	
	/**
	 * �������Դ(���ӳ�)
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	
	/**
	 * �������
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		//�������ӳ��л������
		return dataSource.getConnection();
	}
	
	

}
