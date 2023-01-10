package com.example.demo.netty.eventloop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * 处理普通任务与定时任务的eventLoop、多个不同的eventLoopGroup、
 *
 * @author zaochun.zjw
 * @date 2023/1/4
 */
public class DiscussWorkEventLoop {


    public static void main(String[] args) {
        //diffEventLoop();

        getDoubleEventLoop();
    }

    /**
     * 通过eventLoop执行普通任务/定时任务
     */
    private static void diffEventLoop() {
        // 获取带有两个eventLoop的NioEventLoopGroup,对应两个线程
        EventLoopGroup group = new NioEventLoopGroup(2);
        // 通过next方法可以获得下一个eventLoop
        System.out.println(group.next());
        System.out.println(group.next());

        //通过eventLoop执行普通任务
        group.next().execute(() -> {
            System.out.println(Thread.currentThread().getName() + "hello");
        });

        //通过eventLoop执行定时任务
        group.next().scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + "hello2");
        }, 0, 1, TimeUnit.SECONDS);

        try {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.sleep(3000);

            //该方法会首先切换EventLoopGroup 到关闭状态 从而拒绝新的任务加入，然后在任务队列中的任务都处理完成后，
            // 停止线程的运行，从而确保整体应用是在正常有序状态下退出的
            group.shutdownGracefully();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 传入多个EventLoopGroup参数，分别负责处理不同的事件
     */
    private static void getDoubleEventLoop() {
        EventLoopGroup defaultEventLoop = new DefaultEventLoop();

        new ServerBootstrap().group(new NioEventLoopGroup(1), new NioEventLoopGroup(2))
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //增加 两个处理器 第一个使用NioEventLoopGroup 去处理，第二个使用自定义的EventLoopGroup去处理
                    socketChannel.pipeline().addLast("nioHandler", new ChannelInboundHandlerAdapter() {
                            //ChannelHandlerContext 通道处理器上下文
                            @Override
                            public void channelRead(ChannelHandlerContext context, Object msg) {
                                ByteBuf buf = (ByteBuf) msg;
                                System.out.println(Thread.currentThread().getName() + " " + buf.toString(StandardCharsets.UTF_8));
                                //调用下一个handler
                                context.fireChannelRead(msg);
                            }
                        })
                        .addLast(defaultEventLoop,"myHandler", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext context, Object msg) {
                                ByteBuf buf = (ByteBuf) msg;
                                System.out.println(Thread.currentThread().getName() + " " + buf.toString(StandardCharsets.UTF_8));
                            }
                        });
                }
            }).bind(8080);
    }
}
