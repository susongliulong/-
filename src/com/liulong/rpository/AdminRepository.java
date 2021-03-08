package com.liulong.rpository;

import com.liulong.entry.Admin;

public interface AdminRepository {
    public Admin login(String name, String password);
}
