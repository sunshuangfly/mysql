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
		//ScalarHandler:用于处理聚合函数执行结果(一行一列)
		
		//查询总记录数
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select count(*) from product";
		
		Long obj = queryRunner.query(sql, new ScalarHandler<Long>());
		System.out.println(obj);
		
		//打印obj类型
		//System.out.println(obj.getClass());
	}
	
	@Test
	public void demo2() throws Exception {
		//MapHandler: 将查询到的一条记录,封装到Map中,map.key=字段名,map.value=值
		//主要用途:多表操作,将数据转换成json等
		
		//查询总记录数
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from product where pid=?";
		
		Object[] params = {6};
		
		Map<String, Object> map = queryRunner.query(sql, new MapHandler(), params);
		
		System.out.println(map);
		
	}
}
