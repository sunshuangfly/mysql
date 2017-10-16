package com.sun_c3p0_utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * ���C3p0Utils ��Ч��֮ǰ�� JdbcUtils,�����ṩ����,������ӵĹ�����
 * 
 */
public class C3p0Utils {
	
	//���ӳ�
	private static ComboPooledDataSource dataSource;
	
	//������ӳ�(����Դ)
	public static DataSource getDataSource() {
		return dataSource;
	}

	//�������
	public static Connection getConnection () throws Exception {
		//�����ӳ��л������
		return dataSource.getConnection();
	}
}
