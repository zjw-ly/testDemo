package com.example.demo.eventbus.executor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.concurrent.Executor;


/**
 * Akka执行器
 *
 * @author zaochun.zjw
 * @date 2022/11/7
 */
public class AkkaExecutor implements Executor {

    private static final String NAME_AKKA_SYSTEM = "DeerAkkaSystem";

    private final ActorSystem system;

    private final ActorRef runnableActor;

    public AkkaExecutor() {
        //创建akka 上下文
        system = ActorSystem.create(NAME_AKKA_SYSTEM);
        runnableActor = system.actorOf(RunnableActor.props(), "runnableActor");

        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook(system)));
    }


    @Override
    public void execute(Runnable runnable) {

    }

    private static class RunnableActor extends UntypedActor {

        public static Props props() {
            return Props.create(RunnableActor.class);
        }

        @Override
        public void onReceive(Object message) throws Throwable {
            if (message instanceof Runnable) {
                ((Runnable) message).run();
            }
        }
    }

    private static class ShutdownHook implements Runnable {

        private final ActorSystem actorSystem;

        private ShutdownHook(ActorSystem actorSystem) {
            this.actorSystem = actorSystem;
        }

        @Override
        public void run() {
            try {
                actorSystem.terminate();

                System.out.println(NAME_AKKA_SYSTEM + " shutdown success!");
            } catch (Throwable e) {
                System.out.println(NAME_AKKA_SYSTEM + " shutdown error!");

                e.printStackTrace();
            }
        }
    }
}
