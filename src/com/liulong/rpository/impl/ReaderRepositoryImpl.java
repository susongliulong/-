package com.liulong.rpository.impl;

import com.liulong.entry.Admin;
import com.liulong.entry.Reader;
import com.liulong.rpository.ReaderRepository;
import com.liulong.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderRepositoryImpl implements ReaderRepository {
    @Override
    public Reader login(String name, String password) {
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
            connection= DBUtil.getConnection ();
            Reader reader=null;
            String sql="select * from reader where name=? and password=?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString (1,name);
                statement.setString(2, password);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    reader=new Reader(resultSet.getInt ("id"),resultSet.getString ("name"),resultSet.getString("password"),resultSet.getString ("telephone"),resultSet.getDate ("create_time"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace ();
            }finally {
                DBUtil.release (connection,statement,resultSet);
            }
            return reader;
    }
}
