package com.sharing.controller;

import com.sharing.domain.User;
import com.sharing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆 controller
 *
 * @author 董润华
 */
@RequestMapping("login")
@Controller
public class LoginController {

    // 注入service层
    @Autowired
    private LoginService loginService;

    /**
     * 跳转login页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        System.out.println("跳转login......");
        return "BISHE_login";
    }


    /**
     * 登陆系统
     *
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/loginUser")
    public String loginUser(HttpServletRequest request, String username, String password) {
        // 获取到username
        System.out.println(username);
        System.out.println(password);
        if(null==username||null==password){
            return "BISHE_login";
        }
        // 查询
        Boolean isExist = loginService.LoginUser(username, password);
        if(isExist){
            request.getSession().setAttribute("username", username);
            return "BISHE_index";
        }else {
            return "BISHE_login";
        }
    }

    /**
     * 检查是否登陆
     *
     * @param request
     * @return
     */
    @RequestMapping("/islogin")
    @ResponseBody
    public String islogin(HttpServletRequest request) {
        System.out.println("是否登陆");
        // 从session中获取username
        String username = (String) request.getSession().getAttribute("username");
        if (username != null && !username.equals("")) {
            // 已经登陆过返回true
            return "true";
        } else {
            // 未登录返回false
            return "false";
        }
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username: " + username);
        User user = loginService.getUser(username);
        System.out.println(user.toString());
        return user;
    }

}
