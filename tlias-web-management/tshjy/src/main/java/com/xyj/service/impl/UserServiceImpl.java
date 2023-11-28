package com.xyj.service.impl;

import com.xyj.mapper.UserMapper;
import com.xyj.pojo.User;
import com.xyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User login(String username) {
        return userMapper.selectUser(username);
    }
}
