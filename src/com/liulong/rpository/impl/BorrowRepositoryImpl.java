package com.liulong.rpository.impl;

import com.liulong.entry.Borrow;
import com.liulong.rpository.BorrowRepository;
import com.liulong.utils.DBUtil;
import com.liulong.entry.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepositoryImpl implements BorrowRepository {
    @Override
    public void addBorrow(Integer bookid, Integer readerid, Integer adminid, String createTime, String returnTime, Integer state) {
        Connection connection= DBUtil.getConnection ();
        PreparedStatement statement=null;
        String sql="insert into borrow (bookid,readerid,adminid,borrowtime,returntime,state)values(?,?,null,?,?,0)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookid);
            statement.setInt(2, readerid);
            statement.setString(3,createTime);
            statement.setString(4,returnTime);
            statement.executeUpdate ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release (connection,statement,null);
        }
    }

    @Override
    public List<Borrow> findAllByReaderId(Integer id,Integer index,Integer limit) {

        Connection connection=DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql="select br.id,b.name,b.author,b.publish,r.name,r.telephone,br.borrowtime,br.returntime,br.state " +
                "from book b,reader r,borrow br where r.id=? and r.id=br.readerid and b.id=br.bookid limit ?,?";
        List<Borrow>list=new ArrayList<Borrow> ();
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt (1,id);
            statement.setInt(2, index);
            statement.setInt(3, limit);
            rs=statement.executeQuery();
            while(rs.next ()){
                list.add (new Borrow (rs.getInt (1),
                                      new Book (rs.getString (2), rs.getString (3), rs.getString (4)),
                                      new Reader(rs.getString (5),rs.getString (6)),
                                      rs.getString (7),rs.getString (8),rs.getInt (9)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release(connection, statement, rs);
        }
        return list;
    }

    @Override
    public Integer getBorrowCount(Integer readerid) {
        Connection connection=DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int count=0;
        String sql="select count(*)" + "from book b,reader r,borrow br where r.id=? and r.id=br.readerid and b.id=br.bookid";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt (1,readerid);
            rs=statement.executeQuery();
            while(rs.next ()){
               count=rs.getInt (1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release(connection, statement, rs);
        }
        return count;
    }

    @Override
    public List<Borrow> findAllBorrowByState(int state, int index,int limit) {
        Connection connection=DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sql="select br.id,b.name,b.author,b.publish,r.name,r.telephone,br.borrowtime,br.returntime,br.state " +
                "from book b,reader r,borrow br where br.state=? and r.id=br.readerid and b.id=br.bookid limit ?,?";
        List<Borrow>list=new ArrayList<Borrow> ();
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt (1,state);
            statement.setInt(2, index);
            statement.setInt(3, limit);
            rs=statement.executeQuery();
            while(rs.next ()){
                list.add (new Borrow (rs.getInt (1),
                                      new Book (rs.getString (2), rs.getString (3), rs.getString (4)),
                                      new Reader(rs.getString (5),rs.getString (6)),
                                      rs.getString (7),rs.getString (8),rs.getInt (9)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release(connection, statement, rs);
        }
        return list;
    }

    @Override
    public int getBorrowCountByState(int state) {
        Connection connection=DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int count=0;
        String sql="select count(*)" + "from book b,reader r,borrow br where br.state=? and r.id=br.readerid and b.id=br.bookid";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt (1,state);
            rs=statement.executeQuery();
            while(rs.next ()){
                count=rs.getInt (1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release(connection, statement, rs);
        }
        return count;
    }


}
