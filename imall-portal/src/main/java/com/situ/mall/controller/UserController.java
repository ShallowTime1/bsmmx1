package com.situ.mall.controller;


import com.situ.mall.pojo.User;
import com.situ.mall.service.IUserService;
import com.situ.mall.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/checkUserLogin")
    public JSONResult checkUserLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user == null ? JSONResult.error() : JSONResult.ok();
    }

    @RequestMapping("/getLoginPage")
    public String getLoginPage(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public JSONResult login (String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user == null) {
            return JSONResult.error("账户名或密码错误！！！");
        } else {
            session.setAttribute("user", user);
            return JSONResult.ok("登陆成功");
        }
    }
}
