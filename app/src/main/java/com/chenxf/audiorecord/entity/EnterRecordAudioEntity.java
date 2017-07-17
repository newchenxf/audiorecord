package com.chenxf.audiorecord.entity;

import java.io.Serializable;

/**
 * 进入发布语音界面所需要传递的entity
 * @author Kevin
 * @version V1.0
 * @Date 7/4/16
 * @Description
 */
public class EnterRecordAudioEntity implements Serializable {

    private SourceType sourceType;
    private String replyName;
    //页面标示，在录制完成时返回
    private long pageId;

    public enum SourceType{
        AUDIO_COMMENT,
        AUDIO_FEED
    }

    public void setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }
}
