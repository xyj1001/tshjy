package com.xyj;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "Assignmentspecifications")//签名算法
                .setClaims(claims) //自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("Assignmentspecifications")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5OTQzOTcyN30.O2CEOvAentk4hW-2-egpzmoa6MruQNKf35l--r242l0")
                .getBody();
        String claims1 = Jwts.parser()
                .setSigningKey("Assignmentspecifications")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5OTQzOTcyN30.O2CEOvAentk4hW-2-egpzmoa6MruQNKf35l--r242l0")
                .getSignature();
        System.out.println(claims+" "+ claims1);
    }


    @Test
    public void hashpsd(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "123";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);

        BCryptPasswordEncoder passwordDecoder = new BCryptPasswordEncoder();

        // 使用BCryptPasswordEncoder的matches方法来比较原始密码和加密密码是否匹配
        if (passwordDecoder.matches("123", encodedPassword)) {
            System.out.println("密码匹配");
        } else {
            System.out.println("密码不匹配");
        }
    }

}
