package com.example.demo.netty.eventloop;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * closeFuture - demo
 *
 * @author zaochun.zjw
 * @date 2023/1/4
 */
public class CloseFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();

        ChannelFuture channelFuture = new Bootstrap()
            .group(group)
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new StringEncoder());
                }
            }).connect(new InetSocketAddress("localhost", 8080));
        channelFuture.sync();

        Scanner scanner = new Scanner(System.in);
        Channel channel = channelFuture.channel();

        //创建一个新线程 用来输入数据 并向服务器发送
        new Thread(() -> {
            while (true) {
                String msg = scanner.next();
                if ("close".equals(msg)) {
                    // 这里的关闭主要是指主线程调用channel的关闭， 但是真正需要执行关闭的操作是在NIO线程中执行
                    channel.close();
                    break;
                }
                channel.writeAndFlush(msg);
            }
        }, "inputThread").start();

        // 要想在真正关闭之前执行一些操作，可以获得closeFuture对象，
        ChannelFuture closeFuture = channel.closeFuture();
        System.out.println("waiting close....");

        //同步等待NIO线程执行完close操作， 下面这两个都可以实现
        closeFutureSync(closeFuture,group);
        closeFutureListener(closeFuture,group);

    }

    private static void closeFutureSync(ChannelFuture closeFuture, NioEventLoopGroup group) throws InterruptedException {
        closeFuture.sync();
        System.out.println("执行一些逻辑");

        //关闭eventLoopGroup
        group.shutdownGracefully();
    }

    private static void closeFutureListener(ChannelFuture closeFuture, NioEventLoopGroup group) {
        closeFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                //等待channel关闭后才执行操作
                System.out.println("额外的操作");

                group.shutdownGracefully();
            }
        });
    }
}
