package com.example.demo.netty.firstcase;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty服务器端代码
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public class NettyServer {

    public static void main(String[] args) {
        //1.启动器 负责装配netty组件，启动服务器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //2.创建NioEventLoopGroup ，这里相当于建立线程池 + Selector
        serverBootstrap.group(new NioEventLoopGroup())
            //3.选择服务器的ServerSocketChannel 实现
            .channel(NioServerSocketChannel.class) //某个渠道专门处理read事件
            //4.child 负责处理读写 、 该方法觉了child执行哪些操作
            //ChannelInitializer 处理器仅执行一次
            //它的作用是待客服端SocketChannel建立链接后，执行initChannel以便添加更多的处理器
            .childHandler(new ChannelInitializer<NioServerSocketChannel>() {
                @Override
                protected void initChannel(NioServerSocketChannel nioServerSocketChannel) throws Exception { //创建处理器，在连接建立后才调用其中的方法
                    //5.SocketChannel的处理器，使用StringDecoder解码，ByteBuf -> String
                    nioServerSocketChannel.pipeline().addLast(new StringDecoder());
                    //6.SocketChannel的 业务 处理，使用上一个处理器的处理结果
                    nioServerSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                        //调用自定义处理数据的方法
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

                        }
                    });
                }
                //7.ServerSocketChannel绑定8080端口
            }).bind(8080);
    }
}
