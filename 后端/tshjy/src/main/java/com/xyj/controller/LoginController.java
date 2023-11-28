package com.xyj.controller;

import com.xyj.pojo.Result;
import com.xyj.pojo.User;
import com.xyj.service.UserService;
import com.xyj.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    /**
     *
     *
     * 使用HTTPPOST到URL注册用户https://server.url/registration.
     *         HTTP body for the registration message MUST have the following content:
     *         {
     *         “username” : “username”,
     *         “password” : “password”,
     *         “email” : “user.email@for-contacting.com”
     *         }
     *         After registration, clients MUST authenticate with the username and the password for executing requests to the server. Server MUST NOT accept other than registration requests from unauthorized clients.
     *         Client MUST send passwords using HTTPS. Passwords MUST not be sent over insecure HTTP connections.
     *         Server MUST not store the password, but only store a hash of it. A good hash function MUST be used to make sure hashed passwords are secured and as unique as possible to avoid collisions.
     *         For other than registration requests, users MUST be authenticated using Basic HTTP authentication (see References). Authentication MUST be done over HTTPS using the Authorization header, where username:password string MUST be UTF-8 and MUST be Base64 encoded.
     *         Clients SHOULD cache the user credentials after initial client side authorization for a period of time. Clients may either:
     *         • cache the credentials for a single client session, keeping username and password in memory, or
     *         • save the credentials locally to a file, so user does not need to authenticate unless explicitly logging
     *         out of the chat server.
     *         If client saves the credentials on the client side file, this MUST be done securely
     *         注册后，客户端必须使用用户名和密码进行身份验证，才能执行对服务器的请求。服务器不得接受来自未经授权客户端的注册请求以外的其他请求。
     *         客户端必须使用HTTPS发送密码。密码不得通过不安全的HTTP连接发送。服务器不得存储密码，而只能存储其哈希。必须使用良好的哈希函数来确保哈希密码的安全性和唯一性，以避免冲突。
     *         对于注册请求以外的其他请求，用户必须使用基本HTTP身份验证进行身份验证（请参阅参考资料）。身份验证必须使用Authorization标头通过HTTPS进行，其中username:password字符串必须是UTF-8，并且必须是Base64编码。
     *         客户端应在初始客户端授权后缓存用户凭据一段时间。客户端可以：
     *         •缓存单个客户端会话的凭据，将用户名和密码保存在内存中，或者
     *         •将凭据本地保存到文件中，这样用户就不需要进行身份验证，除非明确注销聊天服务器。如果客户端将凭据保存在客户端文件上，则必须安全地执行此操作
     *
     */
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){

        log.info("员工登录: {}", user);
        // 先保存 用户输入密码
        String rawPsd=user.getPassword();

        // 查询 该用户
        User u = userService.login(user.getUsername());

        //查询到该用户后 进行 密码校验
        if (u != null) {

            BCryptPasswordEncoder passwordDecoder = new BCryptPasswordEncoder();
            // 使用BCryptPasswordEncoder的matches方法来比较原始密码和加密密码是否匹配
            if (passwordDecoder.matches(rawPsd, u.getPassword())) {

                System.out.println("密码匹配");
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", u.getId());
                claims.put("username", u.getUsername());
                String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的员工信息
                return Result.success(jwt);

            }

            }


        //登录失败, 返回错误信息
        return Result.error("用户名或密码错误");

    }




}
