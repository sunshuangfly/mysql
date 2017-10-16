package com.sun.mybatis.dao;

import java.util.List;

import com.sun.mybatis.pojo.User;

public interface UserDao {

	User getUserById(int id); //����ID��ѯ�û���Ϣ
	List<User> getUserByName(String username);//�����û�����ѯ�û��б�
	void insertUser(User user);//����User����
}
