package com.zhongbao.weixin.entity;

/**
 * 视频信息，包含小视频等，小视频对应的为shortvideo，视频对应为video
 */
public class VideoMessage extends BaseMessage {

    private String MediaId;
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
