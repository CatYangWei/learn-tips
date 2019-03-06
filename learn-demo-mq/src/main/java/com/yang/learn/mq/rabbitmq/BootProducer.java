package com.yang.learn.mq.rabbitmq;

import com.rabbitmq.client.*;
import com.yang.learn.mq.rabbitmq.config.Config;

import java.util.concurrent.atomic.AtomicInteger;

public class BootProducer {
    public static void main(String[] args)throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Config.HOST);
        factory.setPort(Config.PORT);
        factory.setUsername(Config.USER_NAME);
        factory.setPassword(Config.PASSWORD);
        Connection connection = factory.newConnection();
        Channel channel= connection.createChannel();

        channel.exchangeDeclare(Config.EXCHANGE_NAME,BuiltinExchangeType.DIRECT,true);
        channel.queueDeclare(Config.QUEUE_NAME,true,false,false,null);
        channel.queueBind(Config.QUEUE_NAME,Config.EXCHANGE_NAME,Config.ROUTE_KEY);

        AtomicInteger atomicInteger = new AtomicInteger(1);

        while (true){
            String message = "MESSAGE,NO-"+atomicInteger.get();
            channel.basicPublish(Config.EXCHANGE_NAME,Config.ROUTE_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println("PUBLISH:"+message);
            Thread.sleep(1000);
            atomicInteger.addAndGet(1);
            if(atomicInteger.get()== 1000000){
                break;
            }
        }

        channel.close();
        connection.close();
    }
}
