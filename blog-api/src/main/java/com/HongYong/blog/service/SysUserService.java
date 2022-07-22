package com.HongYong.blog.service;

import com.HongYong.blog.dao.pojo.SysUser;
import com.HongYong.blog.vo.Result;
import com.HongYong.blog.vo.UserVo;
import org.springframework.stereotype.Repository;

public interface SysUserService {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /*根据token查询用户信息*/
    Result findUserByToken(String token);

    /*根据账户查找用户*/
    SysUser findUserByAccount(String account);

    /*保存用户*/
    void save(SysUser sysUser);
}
