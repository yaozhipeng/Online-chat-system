/**
 * 注册和登陆功能的Controller
 */

package ncu.controller;

import ncu.dto.LoginExecution;
import ncu.dto.Result;
import ncu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = "currentId")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String login(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         HttpServletRequest request) {
        String idKey = "currentId";
        String nameKey = "currentName";
        Result<LoginExecution> result = userService.login(email, password);
        request.getSession().setAttribute("result", result);
        if (result.isSuccess()) {  // 成功把currentId放到session中
            request.getSession().setAttribute(idKey, result.getData().getId());
            request.getSession().setAttribute(nameKey, result.getData().getName());
            return "redirect:/view/home";
        }
        return "redirect:/view/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private String register(@RequestParam("email") String email,
                            @RequestParam("password1") String password1,
                            @RequestParam("password2") String password2,
                            HttpServletRequest request) {
        Result result;
        if (password1 == null || !password1.equals(password2)) {
            result = new Result<>(false, "两次密码不一致");
        } else {
            result = userService.register(email, password1);
        }
        request.getSession().setAttribute("result", result);
        if (!result.isSuccess()) {
            return "redirect:/view/register";
        }
        return "redirect:/view/login";
    }
}
