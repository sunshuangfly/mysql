package com.sun.jdbc_01;

import java.sql.DriverManager;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.NonRegisteringDriver;

public class ApiDemo {

	public void demo01() throws Exception {
		/**
		 * �������
		 * 1,JDBC�淶�涨,�����Ҫ�������ݿ�,�����ṩ�����ӿڵ�ʵ����
		 * 		�����ӿ�:java.sql.Driver
		 * 		ÿһ�����ݿ��ṩ����jar ��ʵ���˸ýӿ�
		 * 2,MySQL �ṩʵ����:com.mysql.jdbc.Driver
		 * 		Դ��:public class Driver extends NonRegisteringDriver implements java.sql.Driver {
		 * 3,JDBC�淶�ṩ��ע��ʵ����ķ�ʽ
		 * 		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 * 		��,�����ѭ��������,Java������mysqlʵ�������(ֱ�ӹ�ϵ),֮���л����ݿ⽫���ܽ���
		 * 		ϣ���ṩ�ķ���ʱ,ֻҪ�л����ݿ�����,�Ϳ����л�ʹ�����ݿ�
		 * 4,ͨ�������,����ע��������׼д��
		 * 		Class.forName("com.mysql.jdbc.Driver");
		 * 		ʹ�÷���ķ��������ƶ�����
		 * 		������ص������ַ�������,���ݾͿ��Դ���������ļ���,ͨ���޸������ļ������л����ݿ�
		 * 		һ���౻���ص��ڴ�,��̬����齫ִ��
		 * 		com.mysql.jdbc.Driver Դ�����
		 * 		static {
		 * 			java.sql.DriverManager.registerDriver(new Driver());
		 * 		}
		 * ע������ע������
		 * 	����:�ֶ�ע������,����ע���˼���?
		 * 		DriverManager.registerDriver(new Driver());
		 * 	ע����2��:
		 * 		��һ��:new Driver()ʱ,Driver�����,��̬�����ִ��,ע��һ��
		 * 		�ڶ���:���Ǻ����ֶ���ע��һ��
		 */
		
		//����:ע������
		Class.forName("com.mysql.jdbc.Driver");
	}
}
