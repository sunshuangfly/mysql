package com.sun_dbcp;

import java.sql.Connection;

import org.junit.Test;

import com.sun_dbcp_utils.DBCPUtils;

public class DBCPDemo2 {

	@Test 
	public void demo1() throws Exception {
		//�������
		Connection conn = DBCPUtils.getConnection();
		
		
		System.out.println(conn);
	}
}
