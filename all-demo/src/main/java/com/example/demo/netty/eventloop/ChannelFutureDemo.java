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

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * channelfuture - demo
 *
 * @author zaochun.zjw
 * @date 2023/1/4
 */
public class ChannelFutureDemo {

    /**
     * 将通道内的实现 简单拆分一下 （实现的功能和IOEventLoopClient demo一样）
     *
     * @throws InterruptedException
     * @throws IOException
     */
    private static void divideChannelFuture() throws InterruptedException, IOException {
        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture channelFuture = bootstrap.group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new StringEncoder());
                }
            })
            //该方法为异步非阻塞方法，主线程调用后不会被阻塞，真正去执行连接操作的是NIO线程
            //NIO线程：NioEventLoopGroup 中的线程
            .connect(new InetSocketAddress("localhost", 8080));

        //上述建立连接的过程是异步非阻塞的，若不通过sync()方法阻塞主线程，等待连接真正建立，这时通过channelFuture.channel()拿到的Channel对象
        // 并不是真正与服务器连接的通道，也就是没法将信息传递给正确的服务器。
        //通过channelFuture.sync()阻塞主线程，同步处理结果，等待连接真正建立好以后，再去获得Channel传递数据，使用该方法，获取Channel和发送数据的都是主线程
        // "该方法用于等待真正的连接建立"
        channelFuture.sync();

        //获取Channel和发送数据的都是主线程
        Channel channel = channelFuture.channel();
        channel.writeAndFlush("xxx");
        System.in.read();
    }

    /**
     * 执行ChannelFuture的addListener 可以在Nio线程中获取Channel并发送数据，而不是在主线程中实现这种方法。
     *
     * @throws InterruptedException
     * @throws IOException
     */
    private static void listenerChannelFuture() throws InterruptedException, IOException {
        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture channelFuture = bootstrap.group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new StringEncoder());
                }
            })
            //该方法为异步非阻塞方法，主线程调用后不会被阻塞，真正去执行连接操作的是NIO线程
            //NIO线程：NioEventLoopGroup 中的线程
            .connect(new InetSocketAddress("localhost", 8080));

        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                Channel channel = channelFuture.channel();
                channel.writeAndFlush("xxx");
            }
        });
    }
}
