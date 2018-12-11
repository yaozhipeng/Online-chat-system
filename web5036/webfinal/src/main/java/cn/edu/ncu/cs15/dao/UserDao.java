package cn.edu.ncu.cs15.dao;

import cn.edu.ncu.cs15.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User queryById(String id);
    User queryByEmail(String email);
    void add(@Param("user") User user);
    void modify(@Param("user") User user);
}
