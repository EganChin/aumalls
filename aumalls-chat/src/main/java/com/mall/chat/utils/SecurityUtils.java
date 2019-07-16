package com.mall.chat.utils;

import com.mall.common.domain.Operator;
import com.mall.common.form.chat.SaveChatForm;
import com.mall.common.service.ChatLogService;
import com.mall.common.utils.RedisWrapper;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.Attribute;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Egan
 * @date 2019/7/14 11:43
 **/
@Component
public class SecurityUtils {

    private static RedisWrapper redisWrapper;

    private static ChatLogService chatLogService;

    public static Map<String,Operator> operatorMap = new ConcurrentHashMap<>();

    @Autowired
    public SecurityUtils(RedisWrapper redisWrapper, ChatLogService chatLogService) {
        SecurityUtils.redisWrapper = redisWrapper;
        SecurityUtils.chatLogService = chatLogService;
    }

    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get();
    }

    public static boolean validate(Channel channel, TextWebSocketFrame textWebSocketFrame) throws InterruptedException {
        String token = getToken(textWebSocketFrame.text());
        Operator operator = null;
        if (!StringUtils.isBlank(token))
            operator = (Operator) redisWrapper.value().get(token);
        if (operator == null) {
            channel.writeAndFlush(new TextWebSocketFrame("(system)请先登录")).sync();
            channel.close();
            return false;
        }

        //用户登录成功
        SecurityUtils.markAsLogin(channel);
        operatorMap.put(token, operator);

        //保存聊天日志
        SaveChatForm form = new SaveChatForm();
        form.setType((operator.isAdmin() ? 1 : 2));
        form.setSenderId(operator.getId());
        form.setContent(textWebSocketFrame.text());
        chatLogService.saveLog(form);

        return true;
    }

    public static String getToken(String text) {
        Pattern pattern = Pattern.compile("^\\(.{32}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
            return matcher.group().replace("(", "");
        return "";
    }


}
