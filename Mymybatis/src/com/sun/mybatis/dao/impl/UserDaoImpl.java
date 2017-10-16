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
		//����id��ѯ�û���Ϣ
		User user = sqlSession.selectOne("getUserById", id);
		//�ر���Դ
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByName(String username) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ�в�ѯ
		List<User> list = sqlSession.selectList("getUserByName", username);
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����û�
		sqlSession.insert("insertUser", user);
		//�ύ����
		sqlSession.commit();
		//�ر���Դ
		sqlSession.close();

	}

}
