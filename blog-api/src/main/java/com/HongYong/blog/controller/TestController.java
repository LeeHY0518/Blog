package com.HongYong.blog.controller;

import com.HongYong.blog.dao.pojo.SysUser;
import com.HongYong.blog.utils.UserThreadLocal;
import com.HongYong.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }

}
