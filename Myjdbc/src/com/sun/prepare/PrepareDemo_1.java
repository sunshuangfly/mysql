package com.sun.prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.sun.jdbc_utils.JdbcUtils;

public class PrepareDemo_1 {

	/**
	 * 之前的代码对数据库操作,其中执行的SQL语句都是写死的,
	 * 对于写死的SQL语句,就可以利用数据库对SQL语法的识别,修改传入的SQL语句,
	 * 进而达到破坏本来的SQL语句,产生了SQL注入的问题
	 * 下面要解决SQL注入的问题,使用
	 * 		PrepareStatement(集成Statement),实际参数都通过'?'占位符来写SQL语句,后面再对占位符的内容进行设置
	 * 		public interface PreparedStatement extends Statement {}
	 */		
	@Test
	public void demo1() {
		//添加:向分类表中添加数据
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//处理sql语句
			String sql = "insert into category(cname) value(?)";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setString(1, "预处理");
			//执行
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo2() {
		//根据id修改
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//处理sql语句
			String sql = "update category set cname = ? where cid = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setString(1, "测试数据");
			psmt.setInt(2, 7);
			//执行
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo3() {
		//添加:根据id删除数据
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//处理sql语句
			String sql = "delete from category where cid = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setInt(1,6);
			//执行
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	
	@Test
	public void demo4() {
		//查询所有
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//处理sql语句
			String sql = "select * from category";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数 (无)
			//执行
			 rs = psmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo5() {
		//根据id查询
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
			//处理sql语句
			String sql = "select * from category where cid = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数 (无)
			psmt.setInt(1, 9);
			//执行
			 rs = psmt.executeQuery();
			 
			 //一般情况,单个查询我们采用if判断
			/*while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+":"+cname);
			}*/
			 
			 if(rs.next()) {
				 System.out.println("有数据");
			 }else {
				 System.out.println("没有数据");
			 }
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			//释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
	}
}
