package com.xiaoyi.personalweb.argumentResolver;

import com.xiaoyi.personalweb.annotation.CurrentUser;
import com.xiaoyi.personalweb.entity.User;
import com.xiaoyi.personalweb.service.UserService;
import com.xiaoyi.personalweb.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {


    private UserService userService;

    @Autowired
    public void setUserInfoService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class) &&
                parameter.getParameterType().isAssignableFrom(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader("token");
        String userId = TokenUtil.getUserInfoByToken(token);
        return userService.queryById(userId);
    }
}
