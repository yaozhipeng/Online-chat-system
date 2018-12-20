/**
 * 视图跳转的Controller
 */

package ncu.controller;

import ncu.dto.*;
import ncu.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private ViewService viewService;

    @RequestMapping(value = "/downloadChat", method = {RequestMethod.POST, RequestMethod.GET})
    private String downloadChat(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<DownloadChatExecution> result = viewService.downloadChat(currentId);
        request.getSession().setAttribute("result", result);
        return "downloadChat";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
    private String home(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<HomeExecution> result = viewService.home(currentId);
        request.getSession().setAttribute("result", result);
        return "home";
    }

    @RequestMapping(value = "/labelFriend", method = {RequestMethod.POST, RequestMethod.GET})
    private String labelFriend(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<LabelFriendExecution> result = viewService.labelFriend(currentId);
        request.getSession().setAttribute("result", result);
        return "labelFriend";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    private String login() {
        return "login";
    }

    @RequestMapping(value = "/managerFriend", method = {RequestMethod.POST, RequestMethod.GET})
    private String managerFriend(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<ManagerFriendExecution> result = viewService.managerFriend(currentId);
        request.getSession().setAttribute("result", result);
        return "managerFriend";
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    private String register(HttpServletRequest request) {
        return "register";
    }

    @RequestMapping(value = "/selfInformation", method = {RequestMethod.POST, RequestMethod.GET})
    private String selfInformation(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<SelfInformationExecution> result = viewService.selfInformation(currentId);
        request.getSession().setAttribute("result", result);
        return "selfInformation";
    }

    @RequestMapping(value = "/selfLabel", method = {RequestMethod.POST, RequestMethod.GET})
    private String selfLabel(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<SelfLabelExecution> result = viewService.selfLabel(currentId);
        request.getSession().setAttribute("result", result);
        return "selfLabel";
    }

    @RequestMapping(value = "/verification", method = {RequestMethod.POST, RequestMethod.GET})
    private String verification(HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        if (currentId == null) {
            return "forward:/view/login";
        }
        Result<VerificationExecution> result = viewService.verification(currentId);
        request.getSession().setAttribute("result", result);
        return "verification";
    }

    @RequestMapping(value = "/testWebsocket", method = {RequestMethod.POST, RequestMethod.GET})
    private String testWebsocket(HttpServletRequest request) {
        return "testWebsocket";
    }
}
