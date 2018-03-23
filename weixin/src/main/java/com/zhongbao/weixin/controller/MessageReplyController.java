package com.zhongbao.weixin.controller;

import com.zhongbao.weixin.entity.TextMessage;
import com.zhongbao.weixin.utils.MessageUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/weixin")
public class MessageReplyController {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MessageReplyController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void messageReply(HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = response.getWriter();

        //接收来的一般都是文本信息
        Map<String,String> map = MessageUtils.xmlToMap(request);
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String msgType = map.get("MsgType");

        //获取事件
        if(msgType.equals("event")){
            msgType = map.get("Event");
        }

        String msgId = map.get("MsgId");
        String content = map.get("Content");

        //回复，回复可以包括各类型的信息
        String replyMessage = null;
        if(MessageUtils.MESSAGE_TEXT.equals(msgType)){

            replyMessage = MessageUtils.initText(toUserName,fromUserName,content);

        }else if(MessageUtils.MESSAGE_SUBSCRIBE.equals(msgType)){

            replyMessage = MessageUtils.initSubcribe(toUserName,fromUserName);
        }

        System.out.println(replyMessage);
        printWriter.write(replyMessage);
        printWriter.close();

    }


}
