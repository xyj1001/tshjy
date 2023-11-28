package com.xyj.controller;

import com.xyj.pojo.Result;
import com.xyj.pojo.User;
import com.xyj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegisterController {
    /**
     *
     *
     * 使用HTTPPOST到URL注册用户https://server.url/registration.

     */
    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public Result register(@RequestBody User user){

        log.info("员工登录: {}", user);
        System.out.println(user);


        // 哈希一下 密码 再保存到数据库
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("hash 之后的密码："+encodedPassword);

        // set 一下hash后的密码
        user.setPassword(encodedPassword);

        System.out.println(user);
        userService.register(user);
            return Result.success();
        }



}
