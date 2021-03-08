package com.liulong.service.impl;

import com.liulong.entry.Admin;
import com.liulong.rpository.AdminRepository;
import com.liulong.rpository.ReaderRepository;
import com.liulong.rpository.impl.AdminRepositoryImpl;
import com.liulong.rpository.impl.ReaderRepositoryImpl;
import com.liulong.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private AdminRepository adminRepository;
    private ReaderRepository readerRepository;
    @Override
    public Object login(String name, String password,String type) {
        Object object=null;
        switch(type){
            case "reader":
                readerRepository=new ReaderRepositoryImpl ();
                object=readerRepository.login (name,password);
                break;
            case "admin":
                adminRepository=new AdminRepositoryImpl();
                object=adminRepository.login(name, password);
                break;
        }
       return object;
    }
}
