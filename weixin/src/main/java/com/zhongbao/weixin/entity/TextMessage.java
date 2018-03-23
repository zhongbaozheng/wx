package com.zhongbao.weixin.entity;

/**
 * 文本类型信息
 */
public class TextMessage extends BaseMessage{

   private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
