package com.zhongbao.weixin.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhongbao.weixin.entity.AccessToken;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.ParseException;

public class WeixinUtils {

    //测试账号 weixin APPID and applidcation secret
    private final static String APPID = "wxc8e2ccd096b98de1";
    private final static String APPSECRET = "dd5e6de2d77fcfa97cb0a7eb6dd2aa8b";

    //get请求
    private static final String accessTokenUrl= "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;



    /**
     * 向微信服务器发送请求获取token,token将保存在本地上的accesstoken.txt文件下
     */
    public static String  getAccessToken() throws IOException, ParseException {

        long currentTime = System.currentTimeMillis();
        long getTime = DateUtils.getDateTime(FileUtils.getAccessTokenFile()[2]);
        String token  = FileUtils.getAccessTokenFile()[0];

        if((token !=null && !token.equals("")&& currentTime-getTime <7200000)){
            return token;
        }

        String access = HttpUtils.doGet(accessTokenUrl);
        AccessToken accessToken = JSON.parseObject(access,AccessToken.class);
        FileUtils.reBuildAccessTokenFile(accessToken.getAccess_token(),accessToken.getExpires_in()+"000",DateUtils.getStringDate());
        return accessToken.getAccess_token();
    }


}
