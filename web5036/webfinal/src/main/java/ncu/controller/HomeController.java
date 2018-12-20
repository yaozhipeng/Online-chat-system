/**
 * 主要的Controller
 * 1 添加删除好友
 * 2 修改个人信息
 * 3 查看他人信息
 * 4 下载聊天记录
 * 5 添加印象
 * 6 删除印象
 */
// method = {RequestMethod.POST, RequestMethod.GET}
package ncu.controller;

import ncu.dto.FindNewFriendExecution;
import ncu.dto.Result;
import ncu.dto.SelfInformationExecution;
import ncu.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/home")
@SessionAttributes(value="currentId")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/findNewFriend", method = {RequestMethod.POST, RequestMethod.GET})
    private String findNewFriend(@RequestParam("key") String key, HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        Result<FindNewFriendExecution> result = homeService.findNewFriend(currentId, key);
        request.getSession().setAttribute("searchResult", result);
        return "redirect:/view/managerFriend";
    }

    @RequestMapping(value = "/addNewFriendRequest",
            method = {RequestMethod.POST, RequestMethod.GET})
    private String addNewFriendRequest(@RequestParam("friendId") String friendId,
                                       HttpServletRequest request) {
        String currentId = (String) request.getSession().getAttribute("currentId");
        homeService.addNewFriendRequest(currentId, friendId);
        return "redirect:/view/home";
    }

    @RequestMapping(value = "/agreeNewFriend",
            method = {RequestMethod.POST, RequestMethod.GET})
    private String agreeNewFriend(@ModelAttribute("currentId") String currentId,
                                  @RequestParam("friendId") String friendId,
                                  HttpServletRequest request) {
        homeService.agreeNewFriend(friendId, currentId);
        return "redirect:/view/home";
    }

    @RequestMapping(value = "/deleteFriend",
            method = {RequestMethod.POST, RequestMethod.GET})
    private String deleteFriend(@ModelAttribute("currentId") String currentId,
                                @RequestParam("friendId") String friendId,
                                HttpServletRequest request) {
        homeService.deleteFriend(currentId, friendId);
        return "redirect:/view/managerFriend";
    }

    @RequestMapping(value = "/updateSelfInformation",
            method = {RequestMethod.POST, RequestMethod.GET})
    private String updateSelfInformation(
            @ModelAttribute("currentId") String currentId,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("motto") String motto,
            @RequestParam("school") String school,
            @RequestParam("phone") String phone,
            HttpServletRequest request
    ) {
        Integer intGender = null;
        if (gender != null) {
            if("男".equals(gender)) {
                intGender = 1;
            } else if ("女".equals(gender)) {
                intGender = 0;
            }
        }
        SelfInformationExecution execution = new SelfInformationExecution(
                currentId, name, null, intGender, motto, school, phone
        );
        // 修改session缓存中的用户名
        request.getSession().setAttribute("currentName", name);
        homeService.updateSelfInformation(execution);
        return "redirect:/view/home";
    }

    @RequestMapping(value = "/label", method = {RequestMethod.POST, RequestMethod.GET})
    private String label(@ModelAttribute("currentId") String currentId,
                                  @RequestParam("friendId") String friendId,
                                  @RequestParam("content") String content,
                                  HttpServletRequest request) {
        homeService.label(currentId, friendId, content);
        return "redirect:/view/home";
    }

    @RequestMapping(value = "/chatHistory",
            method = {RequestMethod.POST, RequestMethod.GET})
    private String chatHistory(@ModelAttribute("currentId") String currentId,
                                @RequestParam("friendId") String friendId,
                                HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        String content = homeService.chatHistory(currentId, friendId);
        String filename = "chatHistory-" + currentId + "-" + friendId;
        // 设置response的头文件下载的方式
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + filename + ".txt");
        ServletOutputStream resOut = response.getOutputStream();
        // 使用缓冲IO流，下载
        BufferedOutputStream out = new BufferedOutputStream(resOut);
        out.write(content.getBytes("UTF-8")); // 这里一定要设置编码方式
        out.flush();
        out.close();
        return "redirect:/view/downloadChat";
    }

}
