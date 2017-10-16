package com.sun.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sun.mybatis.mapper.UserMapper;
import com.sun.mybatis.pojo.User;

public class UserDaoImpl implements UserMapper {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User getUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//根据id查询用户信息
		User user = sqlSession.selectOne("getUserById", id);
		//关闭资源
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询
		List<User> list = sqlSession.selectList("getUserByName", username);
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//插入用户
		sqlSession.insert("insertUser", user);
		//提交事务
		sqlSession.commit();
		//关闭资源
		sqlSession.close();

	}

}
