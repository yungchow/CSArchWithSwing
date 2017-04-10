package com.yc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yc.domain.User;

public class TestCase {
	public static void main(String[] args) {

		Connection con = DBUtil.getConnection();
		String sql = "select * from user_zr where name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "sf");
			ResultSet rs = ps.executeQuery();
			
			User user = null;
			while(rs.next()){
				user = new User();
				user.setNo(rs.getInt("NO"));
				user.setName(rs.getString("NAME"));
				user.setGender(rs.getString("GENDER"));
				user.setPwd(rs.getString("PWD"));
			}
			rs.close();
			System.out.println(user);
		} catch (Exception e) {
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}	
}
