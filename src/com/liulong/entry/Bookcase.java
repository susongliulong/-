package com.liulong.entry;

import java.util.List;

public class Bookcase {

    private Integer id;
    private String name;
    private List<Book>booList;
    public Bookcase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooList() {
        return booList;
    }

    public void setBooList(List<Book> booList) {
        this.booList = booList;
    }
}
