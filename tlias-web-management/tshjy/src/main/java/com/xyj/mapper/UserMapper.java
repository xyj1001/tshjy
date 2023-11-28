package com.xyj.mapper;


import com.xyj.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 部门管理
 */
@Mapper
public interface UserMapper {
    /**
     * registration
     * @no return
     */
    @Insert("insert into user(username, password, email) values(#{username},#{password},#{email})")
    void insertUser(User user);

    @Select("select * from user where username = #{username}")
    User selectUser(String username);
}
