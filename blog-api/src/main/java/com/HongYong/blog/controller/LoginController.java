package com.HongYong.blog.controller;

import com.HongYong.blog.service.LoginService;
import com.HongYong.blog.vo.Result;
import com.HongYong.blog.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        //登录 验证用户 访问用户表，但是
        return loginService.login(loginParams);

    }
}
