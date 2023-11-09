一 Netty的定义
    Netty是一个异步的、基于事件驱动的网络应用框架，用于快速开发可维护、高性能的网络服务器和客服端。

二 关于Netty组件的解释
    1.Channel - 可以理解为数据的通道
    2.Msg - 流动的数据，最开始从客户端输出时会讲String类型的数据转化为ByteBuf，经过pipeline中的各个handler加工，会变成其他类型对象，
最后输出又变成ByteBuf
    3.Handler - 数据的处理工序
    工序有多道，合在一起就是pipeline（传递途径） 。
    pipeline负责发布事件传播给每个handler，handler对自己感兴趣的事件进行处理（重写了感兴趣的事件处理方法）
    pipeline可以有多个handler，处理时会依次调用其中的handler，handler分为Inbound和Outbound两类，其中Inbound 为入站，Outbound为出站
    4.eventLoop可以理解为处理数据的工人
    eventLoop可以管理多个channel的io操作，并且一但eventLoop负责了某个channel，就会将其与channel进行绑定，以后该channel中的io操作都由该eventLoop负责
    eventLoop既可以执行IO操作，一可以进行任务处理，么个eventLoop有自己的任务队列，队列里可以堆放多个channel的待处理任务，任务分为普通任务、定时任务
    eventLoop按照pipeLine顺序，依次按照handler的规划处理数据，可以为每个handler指定不通的eventLoop

一个EventLoop可以负责多个

三 jdk future 与netty future 、 promise区别
![img.png](img.png)


四 netty的优势
1) Netty 抽象出两组线程池BossGroup和WorkerGroup，BossGroup专门负责接收客户端的连接, WorkerGroup专门负责网络的读写；
2) BossGroup和WorkerGroup类型都是NioEventLoopGroup，里面包含很多个NioEventLoop;
3) NioEventLoopGroup 相当于一个事件循环线程组, 这个组中含有多个事件循环线程 ， 每一个事件循环线程是 NioEventLoop;
4) 每个NioEventLoop都有一个selector , 用于监听注册在其上的socketChannel的网络通讯；
5) 每个Boss NioEventLoop线程内部循环执行的步骤有 3 步
   a、处理accept事件 , 与client 建立连接 , 生成 NioSocketChannel；
   b、将NioSocketChannel注册到某个worker NIOEventLoop上的selector；
   c、处理任务队列的任务 ， 即runAllTasks；
6) 每个worker NIOEventLoop线程循环执行的步骤
   a、轮询注册到自己selector上的所有NioSocketChannel 的read, write事件；
   b、处理 I/O 事件， 即read , write 事件， 在对应NioSocketChannel 处理业务；
   c、runAllTasks处理任务队列TaskQueue的任务 ，一些耗时的业务处理一般可以放入TaskQueue中慢慢处理，这样不影响数据在 pipeline 中的流动处理；
7) 每个worker NIOEventLoop处理NioSocketChannel业务时，会使用 pipeline (管道)，管道中维护了很多 handler，处理器用来处理 channel 中的数据。
   总结下来Netty能做到高并发、高性能，他的架构设计有如下特点：
   1、主从Reactor线程模型
   2、NIO多路复用非阻塞
   3、无锁串行化设计思想
   4、零拷贝技术的使用
   5、ByteBuf内存池设计
   6、灵活的TCP参数配置能力
   7、并发优化