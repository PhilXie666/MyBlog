package com.demo.xwx.service;

import com.demo.xwx.entity.User;

public interface UserService {

    /*通过用户名查找用户*/
    public User selectByUsername(String username);

}
