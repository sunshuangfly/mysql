package com.sun_dbutils;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.sun_utils.C3P0Utils;

public class DbUtilsDemo3 {

	@Test
	public void demo1() throws Exception {
		//ScalarHandler:���ڴ���ۺϺ���ִ�н��(һ��һ��)
		
		//��ѯ�ܼ�¼��
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select count(*) from product";
		
		Long obj = queryRunner.query(sql, new ScalarHandler<Long>());
		System.out.println(obj);
		
		//��ӡobj����
		//System.out.println(obj.getClass());
	}
	
	@Test
	public void demo2() throws Exception {
		//MapHandler: ����ѯ����һ����¼,��װ��Map��,map.key=�ֶ���,map.value=ֵ
		//��Ҫ��;:������,������ת����json��
		
		//��ѯ�ܼ�¼��
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from product where pid=?";
		
		Object[] params = {6};
		
		Map<String, Object> map = queryRunner.query(sql, new MapHandler(), params);
		
		System.out.println(map);
		
	}
}
