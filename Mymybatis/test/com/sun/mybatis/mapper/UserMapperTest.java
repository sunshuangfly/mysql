package com.sun.mybatis.mapper;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sun.mybatis.pojo.User;

public class UserMapperTest {
	
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(10);
		
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testGetUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.getUserByName("%张%");
		
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建User对象
		User user = new User();
		user.setUsername("关羽");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("南京");
		userMapper.insertUser(user);
		
		sqlSession.commit();
		sqlSession.close();
	}

}
