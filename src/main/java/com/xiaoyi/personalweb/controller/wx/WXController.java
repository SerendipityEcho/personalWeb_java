package com.xiaoyi.personalweb.controller.wx;

import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/wx")
public class WXController extends WeixinSupport {

    @Value("${weixin.token}")
    private String token;

    @Override
    protected String getToken() {
        return token;
    }

    /**
     * 绑定服务器 GET
     * @param request 请求体
     * @return 是否成功
     */
    @GetMapping("/bind")
    public String wxAuth(HttpServletRequest request){
        /**
         * 开发者通过检验signature对请求进行校验（下面有校验方式）。
         * 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，
         * 则接入生效，成为开发者成功，否则接入失败。
         * 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上.
         */
        if (isLegal(request)) {
            //调用菜单创建接口
            //绑定微信服务器成功
            return request.getParameter("echostr");
        } else {
            //绑定微信服务器失败
            return "绑定失败";
        }
    }

    @Override
    protected BaseMsg handleTextMsg(TextReqMsg msg) {
        return super.handleTextMsg(msg);
    }
}
