package ncu.service;

import ncu.dto.LoginExecution;
import ncu.dto.RegisterExecution;
import ncu.dto.Result;

public interface UserService {
    Result<LoginExecution> login(String email, String password);
    Result<RegisterExecution> register(String email, String password);
}
