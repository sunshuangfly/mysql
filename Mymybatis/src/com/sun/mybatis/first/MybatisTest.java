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
		//1.创建一个SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
	
	@Test
	public void getUserById() throws Exception {
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.使用SqlSession对象执行查询,得到User对象
		User user = sqlSession.selectOne("getUserById", 10);
		//6打印结果
		System.out.println(user);
		//7释放资源
		sqlSession.close();
	}
	
	@Test
	public void getUserByName() throws Exception {
		
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.使用SqlSession对象执行查询,得到User对象
		List<User> list = sqlSession.selectList("getUserByName", "%张%");
		//6打印结果
		for (User user : list) {
			
			System.out.println(user);
		}
		//7释放资源
		sqlSession.close();
	}
	
	@Test
	public void addUser() throws Exception {
		
		//创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建User对象
		User user = new User();
		user.setUsername("小乔");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("上海");
		//插入用户
		sqlSession.insert("insertUser",user);
		//主键返回
		System.out.println(user.getId());
		
		//提交事务
		sqlSession.commit();
		//关闭资源
		sqlSession.close();
		
	}
	
	@Test
	public void deleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//删除用户
		sqlSession.delete("deleteUser", 29);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
	@Test
	public void updateUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("周瑜");
		user.setId(28);
		//删除用户
		sqlSession.update("updateUser", user);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
}
