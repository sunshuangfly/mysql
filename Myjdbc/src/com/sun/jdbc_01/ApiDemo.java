package com.sun.jdbc_01;

import java.sql.DriverManager;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.NonRegisteringDriver;

public class ApiDemo {

	public void demo01() throws Exception {
		/**
		 * 获得驱动
		 * 1,JDBC规范规定,如果需要链接数据库,必须提供驱动接口的实现类
		 * 		驱动接口:java.sql.Driver
		 * 		每一个数据库提供驱动jar 都实现了该接口
		 * 2,MySQL 提供实现类:com.mysql.jdbc.Driver
		 * 		源码:public class Driver extends NonRegisteringDriver implements java.sql.Driver {
		 * 3,JDBC规范提供了注册实现类的方式
		 * 		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 * 		但,如果遵循上面的语句,Java代码语mysql实现类耦合(直接关系),之后切换数据库将不能进行
		 * 		希望提供的方案时,只要切换数据库驱动,就可以切换使用数据库
		 * 4,通常情况下,我们注册驱动标准写法
		 * 		Class.forName("com.mysql.jdbc.Driver");
		 * 		使用反射的方法加载制定的类
		 * 		具体加载的类以字符创体现,内容就可以存放在配置文件中,通过修改配置文件方便切换数据库
		 * 		一个类被加载到内存,静态代码块将执行
		 * 		com.mysql.jdbc.Driver 源码分析
		 * 		static {
		 * 			java.sql.DriverManager.registerDriver(new Driver());
		 * 		}
		 * 注册驱动注意事项
		 * 	问题:手动注册驱动,驱动注册了几次?
		 * 		DriverManager.registerDriver(new Driver());
		 * 	注册了2次:
		 * 		第一次:new Driver()时,Driver类加载,静态代码块执行,注册一次
		 * 		第二次:我们后面手动又注册一次
		 */
		
		//结论:注册驱动
		Class.forName("com.mysql.jdbc.Driver");
	}
}
