package com.mall.chat.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.common.domain.ChatLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Egan
 * @date 2019/7/15 22:30
 **/
public interface ChatLogDao extends BaseMapper<ChatLog> {

    /**
     * 获取每个用户发送的最新消息
     * @date 2019/7/15 22:48
     **/
    @Select("SELECT * FROM (SELECT * FROM chat_log WHERE type = 2 ORDER BY create_time desc) c GROUP BY sender_id ORDER BY create_time desc")
    List<ChatLog> selectOverviewChatLog();

}
