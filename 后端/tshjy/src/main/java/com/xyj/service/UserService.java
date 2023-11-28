package com.xyj.service;


import com.xyj.pojo.User;

public interface UserService {

    /**
     * registration
     * @param
     */
    void register(User user);

    /**
     * login
     * @return
     */
    User login(String username);
}
