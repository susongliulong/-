package com.liulong.service.impl;

import com.liulong.entry.Bookcase;
import com.liulong.rpository.BookRepository;
import com.liulong.rpository.BorrowRepository;
import com.liulong.rpository.impl.BookRepositoryImpl;
import com.liulong.rpository.impl.BorrowRepositoryImpl;
import com.liulong.service.BookService;

import com.liulong.entry.*;
import com.liulong.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository=new BookRepositoryImpl ();
    private BorrowRepository borrowRepository=new BorrowRepositoryImpl ();
    private final int LIMIT=6;
    @Override
    public List <Book> findAll(int page) {
        int index=LIMIT*(page-1);
        return bookRepository.findAll(index,LIMIT);
    }

    @Override
    public int getPages() {
        int count=bookRepository.getCount ();
        int pages=0;
        if(count%LIMIT==0){
            pages=count/LIMIT;
        }else{
            pages=count / LIMIT+1;
        }
        return pages;
    }

    @Override
    public void addBorrow(Integer readerid, Integer bookid) {
        //借书时间
        Date date1=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        String borrowTime=sdf.format (date1);
        //返书时间
        Calendar calendar = Calendar.getInstance();
        calendar.set (Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)+14);
        Date date2=calendar.getTime ();
        String returnTime=sdf.format(date2);
        borrowRepository.addBorrow (bookid,readerid,null,borrowTime,returnTime,0);
    }

    @Override
    public List<Borrow> findAllByReaderId(Integer id,Integer page) {
        int index=LIMIT*(page-1);
        return borrowRepository.findAllByReaderId(id,index,LIMIT);
    }

    @Override
    public int getBorrowPages(Integer readerid) {
        int count=borrowRepository.getBorrowCount (readerid);
        int pages=0;
        if(count%LIMIT==0){
            pages=count/LIMIT;
        }else{
            pages=count / LIMIT+1;
        }
        return pages;
    }

    @Override
    public List<Borrow> findAllByState(int state, Integer page) {
        int index=LIMIT*(page-1);
        return borrowRepository.findAllBorrowByState(state,index,LIMIT);
    }

    @Override
    public Integer getBorrowPagesByState(int state) {
        int count=borrowRepository.getBorrowCountByState(state);
        int pages=0;
        if(count%LIMIT==0){
            pages=count/LIMIT;
        }else{
            pages=count / LIMIT+1;
        }
        return pages;
    }

    @Override
    public void updateBorrowByBorrowId(Integer adminid, Integer id, Integer state) {
        Connection connection= DBUtil.getConnection ();
        PreparedStatement statement=null;
        String sql="update borrow set adminid=?,state=? where id=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt (1,adminid);
            statement.setInt (2,state);
            statement.setInt (3,id);
            statement.executeUpdate ();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }finally {
            DBUtil.release (connection,statement,null);
        }
    }

}
