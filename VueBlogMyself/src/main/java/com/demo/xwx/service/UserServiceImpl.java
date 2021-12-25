package com.demo.xwx.service;

import com.demo.xwx.entity.User;
import com.demo.xwx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
