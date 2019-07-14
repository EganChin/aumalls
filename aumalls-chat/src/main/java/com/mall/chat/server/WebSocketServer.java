package com.mall.chat.server;

import com.mall.chat.handler.WebSocketHandler;
import com.mall.common.exception.NRException;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 基于netty的websocket服务器
 *
 * @author Egan
 * @date 2019/7/12 9:32
 **/
@Component
public class WebSocketServer {

    private final static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private int port;

    public WebSocketServer() {
    }

    public WebSocketServer(int port) {
        this.port = port;
    }

    public void start(){
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        try{
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
            bootstrap.group(worker, boss)
                .channel(NioServerSocketChannel.class)
                .localAddress(this.port)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        logger.info("A new connection has been established.");
                        socketChannel.pipeline().addLast(new HttpServerCodec());
                        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
                        socketChannel.pipeline().addLast(new HttpObjectAggregator(8192));

                        /**
                         * 如果WebSocketHandler的次序在WebSocketServerProtocolHandler之下，会导致使用url引发连接断开的异常
                         **/
                        socketChannel.pipeline().addLast(new WebSocketHandler());
                        socketChannel.pipeline().addLast(
                            new WebSocketServerProtocolHandler("/ws", null, true, 65536*10));
                    }
                });
            ChannelFuture cf = bootstrap.bind().sync();
            logger.info("启动正在监听");
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.warn("中断异常", e);
            throw new NRException("连接中断");
        } finally {
            try {
                worker.shutdownGracefully().sync();
                boss.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                logger.warn("中断异常", e);
            }
        }
    }
}
