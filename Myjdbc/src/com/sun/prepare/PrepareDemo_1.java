package com.sun.prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.sun.jdbc_utils.JdbcUtils;

public class PrepareDemo_1 {

	/**
	 * ֮ǰ�Ĵ�������ݿ����,����ִ�е�SQL��䶼��д����,
	 * ����д����SQL���,�Ϳ����������ݿ��SQL�﷨��ʶ��,�޸Ĵ����SQL���,
	 * �����ﵽ�ƻ�������SQL���,������SQLע�������
	 * ����Ҫ���SQLע�������,ʹ��
	 * 		PrepareStatement(����Statement),ʵ�ʲ�����ͨ��'?'ռλ����дSQL���,�����ٶ�ռλ�������ݽ�������
	 * 		public interface PreparedStatement extends Statement {}
	 */		
	@Test
	public void demo1() {
		//���:���������������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//����sql���
			String sql = "insert into category(cname) value(?)";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setString(1, "Ԥ����");
			//ִ��
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo2() {
		//����id�޸�
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//����sql���
			String sql = "update category set cname = ? where cid = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setString(1, "��������");
			psmt.setInt(2, 7);
			//ִ��
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo3() {
		//���:����idɾ������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//����sql���
			String sql = "delete from category where cid = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ���
			psmt.setInt(1,6);
			//ִ��
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	
	@Test
	public void demo4() {
		//��ѯ����
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//����sql���
			String sql = "select * from category";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ��� (��)
			//ִ��
			 rs = psmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo5() {
		//����id��ѯ
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
			//����sql���
			String sql = "select * from category where cid = ?";
			//���Ԥ�������
			psmt = conn.prepareStatement(sql);
			//����ʵ�ʲ��� (��)
			psmt.setInt(1, 9);
			//ִ��
			 rs = psmt.executeQuery();
			 
			 //һ�����,������ѯ���ǲ���if�ж�
			/*while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}*/
			 
			 if(rs.next()) {
				 System.out.println("������");
			 }else {
				 System.out.println("û������");
			 }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
}
