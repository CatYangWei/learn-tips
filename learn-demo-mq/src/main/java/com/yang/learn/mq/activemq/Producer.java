package com.yang.learn.mq.activemq;

import com.alibaba.fastjson.JSONObject;
import com.yang.learn.mq.pojo.Message;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author coffezcat
 * @title: Producer
 * @description: TODO
 * @date 2019/8/15 15:30
 */
public class Producer {
    public static void main(String[] args)throws Exception {
        //创建连接工厂对象
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        //获取连接对象
        Connection connection = connectionFactory.createConnection();
        //开启连接
        connection.start();
        //使用连接对象获取Session对象,并设置参数
        /*
         * 参数介绍
         *        第一个参数(参数类型boolean)：是否开启事务。(一般不开启事务：false)
         *        第二个参数(参数类型int)：应答模式。(一般设置为自动应答：AUTO_ACKNOWLEDGE)
         *                应答模式分为三种：
         *                          AUTO_ACKNOWLEDGE(自动应答)
         *                          CLIENT_ACKNOWLEDGE(手动应答)
         *                          DUPS_OK_ACKNOWLEDGE
         *
         *   注意：当开启事务的时候，第二个参数值设置哪一种都一样，即第二个参数无意义。
         */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //使用Session对象创建Destination对象,其中参数为：消息队列的名称
        Queue queue = session.createQueue("pop");
        //使用session创建消息生产者对象
        MessageProducer producer = session.createProducer(queue);
        //创建消息对象
        TextMessage message = new ActiveMQTextMessage();
        Message messagevo = new Message();
        messagevo.setPolicyId("PolicyId");
        messagevo.setMsisdn("18883851234");

        String messageExt = JSONObject.toJSONString(messagevo);
        message.setText(messageExt);
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
