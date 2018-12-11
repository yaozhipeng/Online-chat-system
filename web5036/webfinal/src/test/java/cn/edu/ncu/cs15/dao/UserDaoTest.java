package cn.edu.ncu.cs15.dao;

import cn.edu.ncu.cs15.TestBase;
import cn.edu.ncu.cs15.entity.User;
import cn.edu.ncu.cs15.utils.Md5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserDaoTest extends TestBase {
    @Autowired
    private UserDao userDao;

    @Test
    public void queryById() {

    }
    @Test
    public void queryByEmail() {

    }
    @Test
    public void add() {
        User user = new User();
        user.setEmail("email");
        user.setId(UUID.randomUUID().toString());
        String password = "password";
        user.setPassword(Md5Util.encrypt(password));
        System.out.println(user);
        userDao.add(user);
    }
    @Test
    public void modify() {

    }
}
