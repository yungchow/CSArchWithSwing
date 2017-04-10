package com.yc.dao;

import java.sql.SQLException;

import com.yc.domain.User;

public interface UserDao extends BaseDao{
	public User login(String username, String pwd);
	
	public User getUserByName(String name);
}
