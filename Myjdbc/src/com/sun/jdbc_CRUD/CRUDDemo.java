package com.sun.jdbc_CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.sun.jdbc_utils.JdbcUtils;

public class CRUDDemo {

	@Test
	public void demo00()  {
		//ģ��
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			
			//������
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo01()  {
		//����
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			//int update = st.executeUpdate("alter table category add price double");
			int update = st.executeUpdate("insert into category(cname) value('111')");
			//������
			System.out.println(update);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo02() {
		//�޸�
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			int update = st.executeUpdate("alter table category add price double");
			
			//������
			System.out.println(update);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
		
	}
	
	@Test
	public void demo03() {
		//ɾ��
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			int update = st.executeUpdate("delete from category where cname='111'");
			//������
			System.out.println(update);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo04() {
		//ͨ��id��ѯ
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			rs = st.executeQuery("select * from category where cid=2");
			//������
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo05() {
		//��ѯ����
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//������ִ����
			st = conn.createStatement();
			
			//ִ��SQL���
			rs = st.executeQuery("select * from category");
			//������
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
}
