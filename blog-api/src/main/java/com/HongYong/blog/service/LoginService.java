package com.HongYong.blog.service;

import com.HongYong.blog.dao.pojo.SysUser;
import com.HongYong.blog.vo.Result;
import com.HongYong.blog.vo.params.LoginParams;

public interface LoginService {
    /*登录功能*/
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    /*退出登录*/
    Result logout(String token);

   /*注册功能*/
    Result register(LoginParams loginParams);
}
