package com.mall.admin.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Egan
 * @date 2019/7/12 10:51
 **/
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("与客户端建立连接，通道开启！");

        //添加到channelGroup通道组
        WebSocketHandlerPool.channelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("与客户端断开连接，通道关闭！");
        //添加到channelGroup 通道组
        WebSocketHandlerPool.channelGroup.remove(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        logger.info("客户端收到服务器数据：" + msg.text());
        sendAllMessage(msg.text());
    }

    private void sendAllMessage(String message){
        //收到信息后，群发给所有channel
        WebSocketHandlerPool.channelGroup.writeAndFlush( new TextWebSocketFrame(message));
    }
}
