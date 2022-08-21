package com.xiaoyi.personalweb.config;

import com.xiaoyi.personalweb.argumentResolver.LoginUserHandlerMethodArgumentResolver;
import com.xiaoyi.personalweb.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 配置跨越
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                //如果有多个路径需要跨域，只需要将跨域路径放入数组中
                //String []  allowDomain={"http://**","http://*","http://*"};
                //.allowedOrigins(allowDomain)//多url跨域
                .allowedOriginPatterns("*")//设置允许跨域请求的域名
                .allowCredentials(true)//是否允许证书 不写默认开启
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH") //设置允许的方法
                .maxAge(3600);//跨域允许时间
    }

    // 配置token拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/user_register"); //注册
        excludePath.add("/login"); //登录
        excludePath.add("/logout"); //登出
        excludePath.add("/static/**");  //静态资源
        excludePath.add("/swagger-ui.html/**");  //静态资源
        excludePath.add("/assets/**");  //静态资源
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
    }

    // 添加参数解析器
    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}
