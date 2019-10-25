package com.yang.learn.mq.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangweia
 * @title
 * @date 2019年03月15日
 * @since v1.0.0
 */
public class BootProducer {
    public static void main(String[] args)throws Exception {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "10.19.13.49:9097,10.19.13.49:9098,10.19.13.49:9099");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<String, String>(properties);
            AtomicInteger atomicInteger = new AtomicInteger(100);
            while (true){
                String msg = "{\"appId\":\"1\",\"typeName\":\"回省\",\"msgBody\":{\"START_TIME\":\"2019/10/15 08:00:00\",\"MSISDN\":\"13870484857\",\"DES_ID\":\"25\",\"ROAMING_TYPE\":\"2\"} ,\"msgCode\":\"Customer_Roaming\",\"typeCode\":\"back_prov\"}";
                producer.send(new ProducerRecord<String, String>("roamer-topic", msg));
                System.out.println("Sent:" + msg);
                atomicInteger.incrementAndGet();
                TimeUnit.SECONDS.sleep(1);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }

        System.in.read();
    }
}
