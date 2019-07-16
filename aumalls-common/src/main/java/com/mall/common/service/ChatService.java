package com.mall.common.service;

import com.mall.common.domain.ChatLog;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/15 10:25
 **/
public interface ChatService {

    /**
     * 获得最近30条聊天记录
     * @date 2019/7/15 10:33
     * @param userId 用户id
     * @param adminId 管理员id
     **/
    List<ChatLog> getLastChatLog(Integer userId, Integer adminId);

}
