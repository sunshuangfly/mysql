package com.sun.mybatis.mapper;

import java.util.List;

import com.sun.mybatis.pojo.User;

public interface UserMapper {

	User getUserById(int id); //����ID��ѯ�û���Ϣ
	List<User> getUserByName(String username);//�����û�����ѯ�û��б�
	void insertUser(User user);//����User����
}
