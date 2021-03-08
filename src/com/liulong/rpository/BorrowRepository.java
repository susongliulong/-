package com.liulong.rpository;

import com.liulong.entry.Borrow;

import java.util.List;

public interface BorrowRepository {
    public void addBorrow(Integer bookid,Integer readerid,Integer adminid,String createTime,String returnTime,Integer state);
    public List<Borrow>findAllByReaderId(Integer id,Integer index,Integer limit);
    public Integer getBorrowCount(Integer readerid);

    List<Borrow> findAllBorrowByState(int state, int index,int limit);
    int getBorrowCountByState(int state);
}
