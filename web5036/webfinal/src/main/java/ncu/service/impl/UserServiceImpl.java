package ncu.service.impl;

import ncu.dao.InformationDao;
import ncu.dao.UserDao;
import ncu.dto.LoginExecution;
import ncu.dto.RegisterExecution;
import ncu.dto.Result;
import ncu.entity.Information;
import ncu.entity.User;
import ncu.service.UserService;
import ncu.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
