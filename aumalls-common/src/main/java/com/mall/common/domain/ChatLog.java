package com.mall.common.domain;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @author Egan
 * @date 2019/7/15 10:28
 **/
public class ChatLog implements Serializable{

    @TableId
    private Integer chatId;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    private Integer type;
    private Long createTime;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
