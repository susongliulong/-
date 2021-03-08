package com.liulong.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static DataSource dataSource;

    static {
        dataSource= new ComboPooledDataSource("first_database");
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn=dataSource.getConnection ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return conn;
    }

    public static void release(Connection conn, Statement statement, ResultSet rs){
        if(rs!=null){
            try {
                rs.close ();
            } catch (SQLException throwables) {
                throwables.printStackTrace ();
            }
        }
        if(statement!=null){
            try {
                statement.close ();
            } catch (SQLException throwables) {
                throwables.printStackTrace ();
            }
        }
        if(conn!=null){
            try {
                conn.close ();
            } catch (SQLException throwables) {
                throwables.printStackTrace ();
            }
        }
    }

}
