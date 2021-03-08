package com.liulong.entry;

import java.util.Date;

public class Reader {
    private Integer id;
    private String name;
    private String password;
    private String telephone;
    private Date createdDate;

    public Reader(Integer id,String name, String password, String telephone, Date createdDate) {
        this.id=id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.createdDate = createdDate;
    }

    public Reader(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
