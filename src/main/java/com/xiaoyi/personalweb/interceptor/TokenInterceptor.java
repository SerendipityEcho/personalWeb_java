package com.xiaoyi.personalweb.interceptor;

import com.xiaoyi.personalweb.util.TokenUtil;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 第一请求是判断是否支持跨域请求，所以OPTIONS请求需要直接放行
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (null != token) {
            //验证token是否正确
            boolean result = TokenUtil.verify(token);
            if (result) {
                return true;
            }
        }
        response.sendError(401,"没有token,不能访问系统，请先登录");
        return false;
    }

}
