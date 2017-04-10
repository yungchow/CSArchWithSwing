package com.yc.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {

	private static String user;
	private static String pwd;
	private static String url;
	private static String driver;
	private static DataSource ds;
	
	static{
		String path = "com/yc/jdbc/db.properties";
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(path);
		Properties ps = new Properties();
		try {
			ps.load(is);
			user = ps.getProperty("user");
			pwd = ps.getProperty("pwd");
			url = ps.getProperty("url");
			driver = ps.getProperty("driver");
			BasicDataSource ds = new BasicDataSource();
			ds.setUrl(url);
			ds.setDriverClassName(driver);
			ds.setPassword(pwd);
			ds.setUsername(user);
			DBUtil.ds = ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			con = ds.getConnection();
			return con;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
