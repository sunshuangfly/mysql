package com.sun.mybatis.first;

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

public class MybatisTest {
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
	public void getUserById() throws Exception {
		//4.����SqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.ʹ��SqlSession����ִ�в�ѯ,�õ�User����
		User user = sqlSession.selectOne("getUserById", 10);
		//6��ӡ���
		System.out.println(user);
		//7�ͷ���Դ
		sqlSession.close();
	}
	
	@Test
	public void getUserByName() throws Exception {
		
		//4.����SqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.ʹ��SqlSession����ִ�в�ѯ,�õ�User����
		List<User> list = sqlSession.selectList("getUserByName", "%��%");
		//6��ӡ���
		for (User user : list) {
			
			System.out.println(user);
		}
		//7�ͷ���Դ
		sqlSession.close();
	}
	
	@Test
	public void addUser() throws Exception {
		
		//����SqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//����User����
		User user = new User();
		user.setUsername("С��");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("�Ϻ�");
		//�����û�
		sqlSession.insert("insertUser",user);
		//��������
		System.out.println(user.getId());
		
		//�ύ����
		sqlSession.commit();
		//�ر���Դ
		sqlSession.close();
		
	}
	
	@Test
	public void deleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ɾ���û�
		sqlSession.delete("deleteUser", 29);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
	}
	@Test
	public void updateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("���");
		user.setId(28);
		//ɾ���û�
		sqlSession.update("updateUser", user);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
	}
}
