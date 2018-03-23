package com.zhongbao.weixin.entity;

/**
 * 语音信息
 */
public class VoiceMessage extends BaseMessage {

    private String MediaId;
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }


}