package com.sun_c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo_2 {

	@Test
	public void demo01() throws Exception {
		//������ӳ�(����Դ)
		//c3p0 jar�����Զ�����'c3p0-config.xml'�ļ�,����þ����������Ϣ,�����������ļ�namedһֱ
		ComboPooledDataSource dataSource = new ComboPooledDataSource("sun");
		
		//�������
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		
	}
}
