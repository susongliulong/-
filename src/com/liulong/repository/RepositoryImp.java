package com.liulong.repository;

import java.util.List;

public interface RepositoryImp<E> {

    public List<E>findAll();
    public E findById(int id);
    public void delete(int id);
    public void update(int id,String ...args);
    public void add(E element);
}
