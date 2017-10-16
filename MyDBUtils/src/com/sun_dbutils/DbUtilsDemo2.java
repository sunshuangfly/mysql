package com.sun_dbutils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.sun_javabean.Product;
import com.sun_utils.C3P0Utils;

public class DbUtilsDemo2 {

	@Test
	public void demo1() throws Exception {
		//通过id查询详情,将结果封装到JavaBean product
		
		//核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql语句
		String sql = "select * from product where pid=?";
		
		//实际参数
		Object[] params = {6};
		
		//查询并封装
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), params);
		
		System.out.println(product);
	}
	
	@Test
	public void demo2() throws SQLException {
		//查询所有,将每一条记录封装到一个javaBean,然后将JavaBean添加到List中,最后返回List,BeanListHandler
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql语句
		String sql = "select * from product";
		
		//参数为空
		Object[] params = {};
		
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
