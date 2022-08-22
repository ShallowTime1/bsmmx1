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

    @RequestMapping("/getLoginPage")
    public String getLoginPage() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public JSONResult login(String name, String password, String code, HttpSession session) {
        String codeInSession = (String) session.getAttribute("codeInSession");
        if(!codeInSession.equalsIgnoreCase(code)) {
            return JSONResult.error("验证码输入错误");
        }
        User user = userService.login(name, password);
        if(user == null) {
            return JSONResult.error("密码或账号输入错误");
        }else {
            session.setAttribute("user",user);
            return JSONResult.ok("登陆成功");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }


}
