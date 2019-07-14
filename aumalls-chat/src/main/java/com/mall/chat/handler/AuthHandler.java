package com.mall.chat.handler;

import com.mall.chat.utils.SecurityUtils;
import com.mall.common.domain.User;
import com.mall.common.utils.RedisWrapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Egan
 * @date 2019/7/14 11:20
 **/
public class AuthHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Autowired
    private RedisWrapper redisWrapper;

    private final static AttributeKey loginKey = AttributeKey.newInstance("login");

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        Channel channel = channelHandlerContext.channel();
        String token = getToken(textWebSocketFrame.text());
        User user = (User) redisWrapper.value().get(token);
        if(user == null){
            channel.writeAndFlush(new TextWebSocketFrame("(system)请先登录")).sync();
            channel.close();
            return;
        }
        SecurityUtils.markAsLogin(channel);
    }


    private String getToken(String text){
        Pattern pattern = Pattern.compile("^\\(.{32}");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find())
            return matcher.group().replace("(", "");
        return "";
    }
}
