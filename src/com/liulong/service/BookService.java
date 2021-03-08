package com.liulong.service;

import com.liulong.entry.Book;
import com.liulong.entry.Borrow;

import java.util.List;

public interface BookService {
    public List<Book> findAll(int page);
    public int getPages();
    public void addBorrow(Integer readerid,Integer bookid);
    public List<Borrow>findAllByReaderId(Integer id,Integer page);
    public int getBorrowPages(Integer readerid);
    List<Borrow> findAllByState(int state, Integer page);
    public Integer getBorrowPagesByState(int state);

    void updateBorrowByBorrowId(Integer readerid, Integer id, Integer state);
}
