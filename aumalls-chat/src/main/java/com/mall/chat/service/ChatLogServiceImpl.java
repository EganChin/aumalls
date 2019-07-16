package com.mall.chat.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.chat.dao.ChatLogDao;
import com.mall.common.domain.ChatLog;
import com.mall.common.form.chat.SaveChatForm;
import com.mall.common.service.ChatLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Egan
 * @date 2019/7/15 22:07
 **/
@org.springframework.stereotype.Service
@Service(interfaceName = "com.mall.common.service.ChatLogService")
public class ChatLogServiceImpl implements ChatLogService {

    @Resource
    private ChatLogDao chatLogDao;

    @Override
    public List<ChatLog> getOverviews() {
        return chatLogDao.selectOverviewChatLog();
    }

    @Override
    public List<ChatLog> getDetails() {
        QueryWrapper<ChatLog> chatWrapper = new QueryWrapper<ChatLog>()
            .ge("create_time", System.currentTimeMillis()-3*24*60*60*1000)
            .orderByDesc("create_time");
        return chatLogDao.selectList(chatWrapper);
    }

    @Override
    public void saveLog(SaveChatForm form) {
        ChatLog chatLog = new ChatLog();
        chatLog.setSenderId(form.getSenderId());
        chatLog.setContent(form.getContent());
        chatLog.setType(form.getType());
        chatLog.setCreateTime(System.currentTimeMillis());
        chatLogDao.insert(chatLog);
    }
}
