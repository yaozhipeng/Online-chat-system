package cn.edu.ncu.cs15.service;

import cn.edu.ncu.cs15.dto.LoginExecution;
import cn.edu.ncu.cs15.dto.RegisterExecution;
import cn.edu.ncu.cs15.dto.Result;

public interface UserService {
    Result<LoginExecution> login(String email, String password);
    Result<RegisterExecution> register(String email, String password);
}
