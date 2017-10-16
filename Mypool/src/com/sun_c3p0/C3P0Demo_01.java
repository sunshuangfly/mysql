package com.sun_c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo_01 {

	@Test
	public void demo01() throws Exception {
		//������ӳ�(����Դ)
		//c3p0 jar�����Զ�����'c3p0-config.xml'�ļ�,����þ����������Ϣ,�����������ļ�namedһֱ
		ComboPooledDataSource dataSource = new ComboPooledDataSource("sun");
		
		
		/*ComboPooledDataSource datasource = new ComboPooledDataSource();
		
		//���û�����
		datasource.setDriverClass("com.mysql.jdbc.Driver");
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
		datasource.setUser("root");
		datasource.setPassword("root");
		
		//������
		//��ʼ�����ӳ������Ӹ���
		datasource.setInitialPoolSize(5);
		
		//���ӳ�������2��
		datasource.setMinPoolSize(2);
		//���ӳ������ֻ����10������,��������͵�����������
		//����е�11����������,ֻ�ܵȴ�,��Ϊ�������������ؾ���10
		datasource.setMaxPoolSize(10);
		//������ʱ��
		datasource.setMaxIdleTime(60);*/
		
		//�������
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		
	}
}
