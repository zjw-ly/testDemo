package com.example.demo.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

/**
 * 自定义一个Actor
 *
 * @author zaochun.zjw
 * @date 2023/5/6
 */
public class MyActor extends AbstractActor {

//    public Receive createReceive() {
//        return receiveBuilder().match(String.class, result -> {
//            //处理业务逻辑
//            System.out.println("123");
//        }).build();
//    }

    public static void main(String[] args) {
        //定义一个Actor管理仓库
        ActorSystem system = ActorSystem.create("sys");
        //将自定义的Actor放入仓库并起个名字
        ActorRef actorDemo = system.actorOf(Props.create(MyActor.class), "actorDemo");
        //发送消息
        actorDemo.tell("你好",ActorRef.noSender());
    }

}
