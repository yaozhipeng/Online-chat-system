package ncu.dao;

import ncu.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User queryById(String id);
    User queryByEmail(String email);
    void add(@Param("user") User user);
    void modify(@Param("user") User user);
}
