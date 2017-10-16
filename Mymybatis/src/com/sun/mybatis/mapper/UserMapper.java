package com.sun.mybatis.mapper;

import java.util.List;

import com.sun.mybatis.pojo.User;

public interface UserMapper {

	User getUserById(int id); //根据ID查询用户信息
	List<User> getUserByName(String username);//根据用户名查询用户列表
	void insertUser(User user);//插入User对象
}
