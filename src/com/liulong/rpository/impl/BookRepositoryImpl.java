package com.liulong.rpository.impl;

import com.liulong.entry.Book;
import com.liulong.entry.Bookcase;
import com.liulong.rpository.BookRepository;
import com.liulong.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll(int index,int limit) {
        Connection connection= DBUtil.getConnection ();
        PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select * from book,bookcase where book.bookcaseid=bookcase.id limit ?,?";
        List<Book>list=new ArrayList<Book> ();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, index);
            statement.setInt(2, limit);
            rs=statement.executeQuery();
            while(rs.next ()){
                list.add (new Book(rs.getInt (1),rs.getString (2),
                                   rs.getString (3),rs.getString (4),
                                   rs.getInt(5),rs.getDouble (6),
                                   new Bookcase (rs.getInt (9),rs.getString (10))));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release (connection,statement,rs);
        }
        return list;
    }

    @Override
    public Integer getCount() {
        Connection connection= DBUtil.getConnection ();
        PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select count(*) from book,bookcase where book.bookcaseid=bookcase.id";
        int count=0;
        try {
            statement = connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next ()){
               count=rs.getInt (1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release (connection,statement,rs);
        }
        return count;
    }
}
