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
    private Integer userId;
    private String content;
    private Long createTime;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
