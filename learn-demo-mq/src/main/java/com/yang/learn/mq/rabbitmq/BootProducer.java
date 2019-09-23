package com.yang.learn.mq.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.*;
import com.yang.learn.mq.pojo.Message;
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
        Integer count =0;
        while (count<1){
            Message message = new Message();
            message.setPolicyId("PolicyId");
            message.setImsi("18883851234");

            String messageExt = JSONObject.toJSONString(message);
            channel.basicPublish(Config.EXCHANGE_NAME,Config.ROUTE_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,messageExt.getBytes());
            System.out.println("PUBLISH:"+messageExt);
            Thread.sleep(1000);
            atomicInteger.addAndGet(1);
            if(atomicInteger.get()== 1000000){
                break;
            }
            count++;
        }

        channel.close();
        connection.close();
    }
}
