package com.zhongbao.weixin.test;

import com.alibaba.fastjson.JSONObject;
import com.zhongbao.weixin.entity.AccessToken;
import com.zhongbao.weixin.entity.Menu;
import com.zhongbao.weixin.utils.FileUtils;
import com.zhongbao.weixin.utils.HttpUtils;
import com.zhongbao.weixin.utils.MenuUtils;
import com.zhongbao.weixin.utils.WeixinUtils;
import org.springframework.web.util.WebUtils;

import java.io.File;
import java.io.IOException;

public class WeiIxinTest {

    public static void main(String[] args) throws Exception {

        /**
         * 7_JQRzM_APTT_z0kok6FUtcJ2CbWVGY1IMX4Vo6aAzswB-6kwRQshHKssq8Gjdz3aByYBRkmeupOXswmoayYs9eFjldCNChkyzc-mB1oBvmYjGispKf78PQdnYrM5d-OZ14-jYBcqSlsOTDVwiTEUjAIADOE
         7200
         */
        String token  = WeixinUtils.getAccessToken();
        System.out.println(token);

//        Menu m = MenuUtils.initMenu();
//        String respone = MenuUtils.createMenu(m);
//        JSONObject jsonObject = HttpUtils.getJsonObject(respone);
//        System.out.println(jsonObject);
//        System.out.println(MenuUtils.getMenu(MenuUtils.getToken()));
//        System.out.println(MenuUtils.deleteMenu());

//        FileUtils.getAccessTokenFile();
//        FileUtils.reBuildAccessTokenFile("hsjdajdhsj","7200000","2018-03-02 14:56:60");

    }
}
