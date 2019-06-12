package com.xjw.myspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.SunHints;

/**
 * @Author: xiejingwei
 * @Date: 2019/6/12 22:26
 */
@Controller
public class SecurityController {

    /**
     * 自定义登录界面
     * @return
     */
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    /**
     * admin角色可访问
     * @return
     */
    @GetMapping(value = "/adminPage")
    public String adminPage(){
        return "adminPage";
    }

    /**
     * user角色可访问
     * @return
     */
    public String userPage(){
        return "userPage";
    }

    /**
     * 所有人可访问
     * @return
     */
    public String allPage(){
        return "allPage";
    }

}
