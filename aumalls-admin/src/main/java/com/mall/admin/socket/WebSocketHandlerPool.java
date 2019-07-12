package com.mall.admin.socket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 管理websocket连接
 * @author Egan
 * @date 2019/7/12 10:55
 **/
public class WebSocketHandlerPool {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

}
