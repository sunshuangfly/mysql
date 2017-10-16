package com.sun_dbutils;


import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.sun_utils.C3P0Utils;

public class DbUtilsDemo {

	@Test
	public void demo1() throws Exception {
		//有异常抛
		//核心类,把数据源传进去
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//执行update方法
		int i = queryRunner.update("insert into product(pid,pname,price,category_id) values(?,?,?,?)", 99,"测试",100,"c009");
		
		System.out.println(i);
	}
	
	@Test
	public void demo2() throws Exception {
		//有异常抛
		//核心类,把数据源传进去
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//执行update方法
		String sql = "insert into product(pid,pname,price,category_id) values(?,?,?,?)";
		Object[] params = {100,"测试2",200,"c008"};
		int i = queryRunner.update(sql, params);
		
		System.out.println(i);
	}
	
	@Test
	public void demo3() throws Exception {
		//核心类,把数据源传进去
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//编写SQL语句
		String sql = "update product set pname=?,price=?,category_id=? where pid=?";
		//编写实际参数
		Object[] params = {"芒果酒",199,"c007",13};
		//处理结果集
		int i = queryRunner.update(sql, params);
		System.out.println(i);
	}
	
	@Test
	public void demo4() throws Exception {
		//核心类,把数据源传进去
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//编写SQL语句
		String sql = "delete from product where pid=?";
		//编写实际参数
		Object[] params = {100};
		//处理结果集
		int i = queryRunner.update(sql, params);
		System.out.println(i);
	}
	
	@Test
	public void demo5() throws Exception {
		//核心类,把数据源传进去
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//编写SQL语句
		String sql = "select * from product";
		//编写实际参数
		//queryRunner.q
		//处理结果集
		
	}
}
