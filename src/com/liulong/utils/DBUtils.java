package com.liulong.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static Connection getConnection() throws SQLException {

//        String user="root";
//        String password="1234";
//        String url="jdbc:mysql://localhost:3306/first_database?useUnicode=true&character=UTF-8&serverTimezone=UTC";
//        Connection connection = null;
//        try {
//            Class.forName ("com.mysql.cj.jdbc.Driver");
//            connection= DriverManager.getConnection (url,user,password);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace ();
//        }
//        return connection;

        ComboPooledDataSource dataSource=new ComboPooledDataSource("first_database");
        Connection connection=null;
        connection=dataSource.getConnection ();
        return connection;
    }

    public static void main(String[] args) {
        try {
            System.out.println(DBUtils.getConnection ());
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }
}
