package com.mall.common.form.chat;

import java.io.Serializable;

/**
 * @author Egan
 * @date 2019/7/15 22:56
 **/
public class SaveChatForm implements Serializable{

    private Integer senderId;
    private String content;
    private Integer type;

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
