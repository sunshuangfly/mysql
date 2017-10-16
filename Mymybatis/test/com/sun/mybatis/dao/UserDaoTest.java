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
		//1.����һ��SqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.���������ļ�
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.����SqlSessionFactory����
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
		List<User> list = userDao.getUserByName("%��%");
		for (User user : list) {
			
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		UserMapper userDao = new UserDaoImpl(sqlSessionFactory);
		//����User����
		User user = new User();
		user.setUsername("���");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("����");
		//����user����
		userDao.insertUser(user);
	
	}

}
