package com.shixue.app.ui.bean;

/**
 * 本页：聊天消息
 * Created by jjs on 2016-12-22.
 * Email:994462623@qq.com
 */

public class VideoMessageBean {
    long id;//用户id
    String name;//用户名
    String chatText;//纯文本
    String richText;//富文本
    int messageID;//聊天id号

    public VideoMessageBean() {

    }

    public VideoMessageBean(long id, String name, String chatText, String richText, int messageID) {
        this.id = id;
        this.name = name;
        this.chatText = chatText;
        this.richText = richText;
        this.messageID = messageID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }

    public String getRichText() {
        return richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
}
