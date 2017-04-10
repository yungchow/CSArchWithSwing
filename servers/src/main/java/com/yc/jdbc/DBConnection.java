package com.yc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    Connection conn = null;

    public DBConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public static void close(ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pst) {

        try {
            if (pst != null) {
                pst.close();
                pst = null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
