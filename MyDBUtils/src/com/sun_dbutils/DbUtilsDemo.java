package com.sun_dbutils;


import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.sun_utils.C3P0Utils;

public class DbUtilsDemo {

	@Test
	public void demo1() throws Exception {
		//���쳣��
		//������,������Դ����ȥ
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//ִ��update����
		int i = queryRunner.update("insert into product(pid,pname,price,category_id) values(?,?,?,?)", 99,"����",100,"c009");
		
		System.out.println(i);
	}
	
	@Test
	public void demo2() throws Exception {
		//���쳣��
		//������,������Դ����ȥ
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//ִ��update����
		String sql = "insert into product(pid,pname,price,category_id) values(?,?,?,?)";
		Object[] params = {100,"����2",200,"c008"};
		int i = queryRunner.update(sql, params);
		
		System.out.println(i);
	}
	
	@Test
	public void demo3() throws Exception {
		//������,������Դ����ȥ
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//��дSQL���
		String sql = "update product set pname=?,price=?,category_id=? where pid=?";
		//��дʵ�ʲ���
		Object[] params = {"â����",199,"c007",13};
		//��������
		int i = queryRunner.update(sql, params);
		System.out.println(i);
	}
	
	@Test
	public void demo4() throws Exception {
		//������,������Դ����ȥ
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//��дSQL���
		String sql = "delete from product where pid=?";
		//��дʵ�ʲ���
		Object[] params = {100};
		//��������
		int i = queryRunner.update(sql, params);
		System.out.println(i);
	}
	
	@Test
	public void demo5() throws Exception {
		//������,������Դ����ȥ
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		//��дSQL���
		String sql = "select * from product";
		//��дʵ�ʲ���
		//queryRunner.q
		//��������
		
	}
}
