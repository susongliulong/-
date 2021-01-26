package com.liulong.repository;

import com.liulong.entry.User;
import com.liulong.utils.DBUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements RepositoryImp<User>{

    static Connection connection=null;
    Statement statement;
    ResultSet resultSet;
    static {
        try {
            connection= DBUtils.getConnection ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }


    @Override
    public List<User> findAll() {

        List<User>list = new ArrayList<User> ();
        try {
            statement=connection.createStatement();
            String sql="select * from user";
            resultSet=statement.executeQuery(sql);
            User user=null;
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString ("name");
                String password=resultSet.getString("password");
                user=new User(id,name,password);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return list;
    }

    @Override
    public User findById(int id) {

        User user = null;
        String sql="select * from user where id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt (1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next ()){
                int the_id=resultSet.getInt("id");
                String name=resultSet.getString ("name");
                String password=resultSet.getString("password");
                user=new User(the_id,name,password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
        return user;
    }

    @Override
    public void delete(int id) {
        String sql="delete from user where id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt (1,id);
            preparedStatement.executeUpdate ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    /**
     *
     * @param id
     * @param args 多个参数，第一个为name,第二个为password
     */
    @Override
    public void update(int id, String... args) {
        String sql="update user set name=?,password=? where id="+id;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString (1,args[0]);
            preparedStatement.setString(2, args[1]);
            preparedStatement.executeUpdate ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }

    @Override
    public void add(User user) {
        String sql="insert into user (name,password) values(?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName ());
            preparedStatement.setString(2, user.getPassword ());
            preparedStatement.executeUpdate ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }
    }
}
