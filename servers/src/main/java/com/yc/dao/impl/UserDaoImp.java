package com.yc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.yc.dao.UserDao;
import com.yc.domain.User;
import com.yc.jdbc.DBUtil;

public class UserDaoImp extends BaseDaoImp implements UserDao{

	@Override
	public User login(String username, String pwd) {
		try {
			Connection conn = DBUtil.getConnection();
	        String sql = "SELECT * FROM user_zr WHERE name=? AND pwd=?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, username);
	        pst.setString(2, pwd);
	        ResultSet rs = pst.executeQuery();
	        return assembleUser(rs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
   }
	
	public User getUserByName(String name) {
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from user_zr where name=?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, name);
	        System.out.println("name: "+name);
			ResultSet result = pst.executeQuery();
			return assembleUser(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	private User assembleUser(ResultSet result) {
		try {
			User user = null;
			if (null != result && result.next()) {
				Integer id = result.getInt("NO");
				String userName = String.valueOf(result.getString("NAME"));
				String gender = result.getString("GENDER");
				String pwd = result.getString("PWD");
				user =  new User(id, userName, gender, pwd);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
