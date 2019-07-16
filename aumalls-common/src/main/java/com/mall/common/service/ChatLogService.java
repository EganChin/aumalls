package com.mall.common.service;

import com.mall.common.domain.ChatLog;
import com.mall.common.form.chat.SaveChatForm;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/15 22:08
 **/
public interface ChatLogService {

    /**
     * 获得数名用户的最后发言信息
     * @date 2019/7/15 22:15
     **/
    List<ChatLog> getOverviews();

    /**
     * 获得一个用户和管理员的若干条最新聊天消息
     * @date 2019/7/15 22:17
     **/
    List<ChatLog> getDetails();

    /**
     * 保存聊天信息
     * @date 2019/7/15 22:56
     * @param form
     **/
    void saveLog(SaveChatForm form);

}
