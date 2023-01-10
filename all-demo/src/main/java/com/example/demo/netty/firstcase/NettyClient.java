package com.example.demo.netty.firstcase;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * netty客服端代码
 *
 * @author zaochun.zjw
 * @date 2023/1/4
 */
public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
            //选择客服Socket实现类，NioSocketChannel 表示基于NIO的客户端实现
            .channel(NioSocketChannel.class)
            //ChannelInitializer 处理器（仅执行一次）
            //他的作用是待客户端SocketChannel建立连接后，执行initChannel以便于添加更多的处理器
            .handler(new ChannelInitializer<Channel>() {

                @Override
                protected void initChannel(Channel ch) throws Exception {
                    //消息经过通道handler处理，这里是将 String -> ByteBuf 编码发出
                    ch.pipeline().addLast(new StringEncoder());
                }
            })
            .connect(new InetSocketAddress("localhost",8080))
            .sync()
            .channel()
            .writeAndFlush("Hello World");
    }
}
