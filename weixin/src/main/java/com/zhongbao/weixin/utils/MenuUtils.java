package com.zhongbao.weixin.utils;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.zhongbao.weixin.entity.Button;
import com.zhongbao.weixin.entity.ClickButton;
import com.zhongbao.weixin.entity.Menu;
import com.zhongbao.weixin.entity.ViewButton;

import java.io.IOException;

public class MenuUtils {

    //https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
    private static final String MENU_CREATE = " https://api.weixin.qq.com/cgi-bin/menu/create";

    private static final String MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete";

    private static final String MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get";


    /**
     * 初始化菜单
     */
    public static Menu initMenu(){
        Menu menu = new Menu();
        ClickButton button11 = new ClickButton();  //菜单1
        button11.setName("点击菜单");
        button11.setType("click");
        button11.setKey("11");

        ViewButton button21 = new ViewButton();    //菜单2
        button21.setName("View菜单");
        button21.setType("view");
        button21.setUrl("http://www.baidu.com");

        ClickButton button31 = new ClickButton();   //二级菜单
        button31.setKey("31");
        button31.setType("scancode_push");
        button31.setName("扫描事件");

        ClickButton button32 = new ClickButton();   //二级菜单
        button32.setKey("32");
        button32.setType("location_select");
        button32.setName("地理位置");

        Button button = new Button();    //菜单3
        button.setSub_button(new Button[]{button31,button32});
        button.setName("菜单");

        menu.setButton(new Button[]{button11,button21,button});

        return menu;
    }

    /**
     * 获取token
     */
    public static String getToken() throws Exception {

        return WeixinUtils.getAccessToken();
    }

    /**
     * 创建菜单
     * @param menu
     * @return
     */
    public static String createMenu(Menu menu) throws Exception{

        String MENU_CREATE_URL = MENU_CREATE+ "?access_token="+getToken();

        return  HttpUtils.doPost(MENU_CREATE_URL, JSON.toJSONString(menu));
    }

    /**
     * 删除菜单,Get请求
     */
    public static String deleteMenu() throws Exception{

        String MENU_DELETE_URL = MENU_DELETE+"?access_token="+getToken();

        return  HttpUtils.doGet(MENU_DELETE_URL);
    }

    /**
     * 查询菜单，Get请求
     * @return
     */
    public static String getMenu() throws Exception{

        String MENU_GET_URL = MENU_GET+"?access_token="+getToken();

        return  HttpUtils.doGet(MENU_GET_URL);
    }

}
