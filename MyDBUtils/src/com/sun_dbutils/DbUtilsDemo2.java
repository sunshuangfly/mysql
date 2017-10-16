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
		//ͨ��id��ѯ����,�������װ��JavaBean product
		
		//������
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql���
		String sql = "select * from product where pid=?";
		
		//ʵ�ʲ���
		Object[] params = {6};
		
		//��ѯ����װ
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), params);
		
		System.out.println(product);
	}
	
	@Test
	public void demo2() throws SQLException {
		//��ѯ����,��ÿһ����¼��װ��һ��javaBean,Ȼ��JavaBean��ӵ�List��,��󷵻�List,BeanListHandler
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql���
		String sql = "select * from product";
		
		//����Ϊ��
		Object[] params = {};
		
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
