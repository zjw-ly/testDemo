package com.example.demo.netty.eventloop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.StandardCharsets;

/**
 * 处理IO任务服务端
 *
 * @author zaochun.zjw
 * @date 2023/1/4
 */
public class IOEventLoopServer {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(new NioEventLoopGroup())
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    // 入站处理器通常是ChannelInboundHandlerAdapter的子类 ，主要用于读取客户端数据，写回结果。 这个主要按照addList的顺序执行的
                    // 出站处理器通常是ChannelOutboundHandlerAdapter的子类，主要对写回结果进行加工。这个主要一句addList的逆序执行

                    socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) {
                            ByteBuf buf = (ByteBuf) msg;
                            System.out.println(Thread.currentThread().getName() + " " + buf.toString(StandardCharsets.UTF_8));
                        }
                    });
                }
            }).bind(8080);
    }
}
