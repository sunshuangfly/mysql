package com.sun.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sun.mybatis.dao.impl.UserDaoImpl;
import com.sun.mybatis.mapper.UserMapper;
import com.sun.mybatis.pojo.User;

public class UserDaoTest {

	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws Exception {
		//1.创建一个SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
	@Test
	public void testGetUserById() {
		UserMapper userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.getUserById(10);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		UserMapper userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.getUserByName("%张%");
		for (User user : list) {
			
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		UserMapper userDao = new UserDaoImpl(sqlSessionFactory);
		//创建User对象
		User user = new User();
		user.setUsername("李白");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("北京");
		//插入user对象
		userDao.insertUser(user);
	
	}

}
