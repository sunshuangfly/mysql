package com.sun.jdbc_CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.sun.jdbc_utils.JdbcUtils;

public class CRUDDemo {

	@Test
	public void demo00()  {
		//模板
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			
			//处理结果
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo01()  {
		//插入
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			//int update = st.executeUpdate("alter table category add price double");
			int update = st.executeUpdate("insert into category(cname) value('111')");
			//处理结果
			System.out.println(update);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo02() {
		//修改
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			int update = st.executeUpdate("alter table category add price double");
			
			//处理结果
			System.out.println(update);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
		
	}
	
	@Test
	public void demo03() {
		//删除
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			int update = st.executeUpdate("delete from category where cname='111'");
			//处理结果
			System.out.println(update);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo04() {
		//通过id查询
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			rs = st.executeQuery("select * from category where cid=2");
			//处理结果
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo05() {
		//查询所有
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//获得语句执行者
			st = conn.createStatement();
			
			//执行SQL语句
			rs = st.executeQuery("select * from category");
			//处理结果
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
}
