package com.imooc.controller;

import com.google.gson.Gson;
import com.imooc.dataobject.WeixinAuthInfo;
import com.imooc.dataobject.WeixinUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

/**
 * Created by cmy on 2017/9/4
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {


//    微信客户端打开链接
//    https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd80db296b9e424f0&redirect_uri=http://chwm.natapp1.cc/weixin/auth&response_type=code&scope=snsapi_userinfo&state=test

    private static final String APP_ID = "wxd80db296b9e424f0";
    private static final String APP_SECRET = "705930de57c150d185a90f4971b5f193";

    @GetMapping("/auth")
    public String auth(@RequestParam("code") String code) {
        log.info("code:{}", code);
        //获取accessToken
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
        url = String.format(url, APP_ID, APP_SECRET, code);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response:{}", response);

        //拉取用户信息
        WeixinAuthInfo authInfo = new Gson().fromJson(response, WeixinAuthInfo.class);
        String accessToken = authInfo.getAccess_token();
        String openId = authInfo.getOpenid();
        url = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
        url = String.format(url, accessToken, openId);
        response = restTemplate.getForObject(url, String.class);

        try {
            response = new String(response.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        log.info("userInfo:{}", response);

        WeixinUserInfo userInfo = new Gson().fromJson(response, WeixinUserInfo.class);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("昵称：%s", userInfo.getNickname()));
        sb.append("</br>");
        sb.append(String.format("性别：%s", userInfo.getSex() == 1 ? "男" : "女"));
        sb.append("</br>");
        sb.append(String.format("国家：%s", userInfo.getCountry()));
        sb.append("</br>");
        sb.append(String.format("省份：%s", userInfo.getProvince()));
        return sb.toString();
    }

    @GetMapping("/wechat")
    public String wechar(@RequestParam("signature") String signature,
                         @RequestParam("timestamp") String timestamp,
                         @RequestParam("nonce") String nonce,
                         @RequestParam("echostr") String echostr) {
        System.out.println("signature:" + signature);
        System.out.println("timestamp:" + timestamp);
        System.out.println("nonce:" + nonce);
        System.out.println("echostr:" + echostr);
        return echostr;
    }

}
