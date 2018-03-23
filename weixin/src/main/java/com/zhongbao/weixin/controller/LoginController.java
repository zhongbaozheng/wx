package com.zhongbao.weixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/weixin")
public class LoginController {

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(){
        return null;
    }
}
