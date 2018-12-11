package cn.edu.ncu.cs15.service.impl;

import cn.edu.ncu.cs15.dao.InformationDao;
import cn.edu.ncu.cs15.dao.UserDao;
import cn.edu.ncu.cs15.dto.LoginExecution;
import cn.edu.ncu.cs15.dto.RegisterExecution;
import cn.edu.ncu.cs15.dto.Result;
import cn.edu.ncu.cs15.entity.Information;
import cn.edu.ncu.cs15.entity.User;
import cn.edu.ncu.cs15.service.UserService;
import cn.edu.ncu.cs15.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Line;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private InformationDao informationDao;

    @Override
    @Transactional
    public Result<LoginExecution> login(String email, String password) {
        User user = userDao.queryByEmail(email);
        if (user == null) { // 不存在用户
            return new Result<>(false, "用户不存在！");
        }
        if (!user.getPassword().equals(Md5Util.encrypt(password))) { // 密码错误
            return new Result<>(false, "密码错误！");
        }

        Information information = informationDao.queryById(user.getId());
        LoginExecution execution = new LoginExecution(information.getName(), user.getId());
        return new Result<>(true, execution);
    }

    @Override
    @Transactional
    public Result<RegisterExecution> register(String email, String password) {
        User user = userDao.queryByEmail(email);
        if (user != null) {
            return new Result<>(false, "邮箱已经注册！");
        }
        user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(email);
        user.setPassword(Md5Util.encrypt(password));
        userDao.add(user); // 写入User表
        Information information = new Information();
        information.setUserId(user.getId());
        informationDao.add(information);
        return new Result<>(true, new RegisterExecution(email));
    }
}
