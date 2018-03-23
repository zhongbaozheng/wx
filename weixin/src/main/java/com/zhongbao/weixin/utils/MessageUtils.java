package com.zhongbao.weixin.utils;

import com.thoughtworks.xstream.XStream;
import com.zhongbao.weixin.controller.MessageReplyController;
import com.zhongbao.weixin.entity.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtils {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MessageUtils.class);

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_NEWS = "news";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_MUSIC = "music";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVNET = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";
    public static final String MESSAGE_SCANCODE= "scancode_push";


    /**
     *
     * xml转化为map
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException,DocumentException{

        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream in = request.getInputStream();
        Document document = reader.read(in);
        Element root = document.getRootElement();
        List<Element> list = root.elements();

        for(Element e:list){
            map.put(e.getName(),e.getText());
        }

        in.close();
        return map;
    }


    /**
     * message转化为xml
     * @param message
     * @return
     */
    public static String textMessageToXml(TextMessage message){

        XStream xStream = new XStream();
        xStream.alias("xml",message.getClass());   //替换
        return xStream.toXML(message);
    }


    //初始化关注
    public static String initSubcribe(String toUserName,String fromUserName){

        String replyMessage = null;

        TextMessage text = new TextMessage();
        text.setToUserName(fromUserName);
        text.setFromUserName(toUserName);
        text.setCreateTime(new Date().getTime());
        text.setMsgType(MESSAGE_TEXT);
        text.setContent("欢迎关注我的微信公众号！\n" +
                "回复“0”：可以查看功能菜单 \n" +
                "回复“1”：可以查看功能一 \n" +
                "回复“2”：可以查看功能二 \n");
        replyMessage = MessageUtils.textMessageToXml(text);

        return replyMessage;

    }


    /**
     * 消息回复初始化
     * @param toUserName
     * @param fromUserName
     * @param content
     */
    public static String initText(String toUserName,String fromUserName,String content){

        //返回主菜单
        String replyMessage = null;

        if(content.equals("0")){
            TextMessage text = new TextMessage();
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MESSAGE_TEXT);
            text.setContent("主菜单：\n" +
                    "菜单一：功能一\n" +
                    "菜单二：功能二");
            replyMessage = MessageUtils.textMessageToXml(text);

        }else if(content.equals("1")){
            TextMessage text = new TextMessage();
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MESSAGE_TEXT);
            text.setContent("功能一");
            replyMessage = MessageUtils.textMessageToXml(text);

        }else if(content.equals("2")){
            TextMessage text = new TextMessage();
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MESSAGE_TEXT);
            text.setContent("功能二");
            replyMessage = MessageUtils.textMessageToXml(text);
        }else {
            TextMessage text = new TextMessage();
            text.setToUserName(fromUserName);
            text.setFromUserName(toUserName);
            text.setCreateTime(new Date().getTime());
            text.setMsgType(MESSAGE_TEXT);
            text.setContent("输入“0”可以查看更多信息！");
            replyMessage = MessageUtils.textMessageToXml(text);
        }
        return replyMessage;


    }
}
