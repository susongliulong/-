package com.liulong.rpository;

import com.liulong.entry.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> findAll(int index,int limit);
    public Integer getCount();
}
