package com.liulong.rpository.impl;

import com.liulong.entry.Admin;
import com.liulong.rpository.AdminRepository;
import com.liulong.utils.DBUtil;

import java.sql.*;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    Connection connection;
    PreparedStatement statement;
    ResultSet resultSet;
    @Override
    public Admin login(String name, String password) {
        connection= DBUtil.getConnection ();
        Admin admin=null;
        String sql="select * from admin where name=? and password=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString (1,name);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                admin=new Admin(resultSet.getString ("name"),resultSet.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release (connection,statement,resultSet);
        }
        return admin;
    }
}
