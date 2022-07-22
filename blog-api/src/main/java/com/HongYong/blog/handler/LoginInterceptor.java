package com.HongYong.blog.handler;

import com.HongYong.blog.dao.pojo.SysUser;
import com.HongYong.blog.service.LoginService;
import com.HongYong.blog.utils.UserThreadLocal;
import com.HongYong.blog.vo.ErrorCode;
import com.HongYong.blog.vo.Result;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在执行controller的方法（Handler）之前进行执行

        /*
         * 1.需要判断 请求的接口路径 是否为HandlerMethod(controller方法)
         * 2.判断token是否为空 如果为空 未登录
         * 3.如果token不为空  登录验证loginService checkToken
         * 4.如果认证成功  放行即可
         */
        if (!(handler instanceof HandlerMethod)){
            //handle 可能是 RequestResourceHandler springboot 程序 访问静态资源 默认去classpath下的src目录去查询
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("==========request start==========");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}",token);
        log.info("==========request end==========");

        if (StringUtils.isBlank(token)){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser == null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //登录验证成功 放行
        //希望在controller中 直接获取用户的信息 怎么获取？
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除ThreadLocal中用完的信息 会有内存泄露的风险
        UserThreadLocal.remove();
    }
}
