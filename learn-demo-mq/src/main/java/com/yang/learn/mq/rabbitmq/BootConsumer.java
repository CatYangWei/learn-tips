package com.yang.learn.mq.rabbitmq;

import com.rabbitmq.client.*;
import com.yang.learn.mq.rabbitmq.config.Config;

import java.io.IOException;

public class BootConsumer {
    public static void main(String[] args)throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Config.HOST);
        factory.setPort(Config.PORT);
        factory.setUsername(Config.USER_NAME);
        factory.setPassword(Config.PASSWORD);
        Connection connection = factory.newConnection();
        Channel channel= connection.createChannel();
        channel.basicQos(64);
        channel.basicConsume(Config.QUEUE_NAME,new DefaultConsumer(channel){
            /**
             * No-op implementation of {@link Consumer#handleDelivery}.
             *
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("RE:"+new String(body));
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
        System.in.read();
        channel.close();
        connection.close();
    }


}
