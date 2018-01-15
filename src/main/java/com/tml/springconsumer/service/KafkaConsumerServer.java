package com.tml.springconsumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerServer{

    @KafkaListener(topics = "topic_1",group = "group_2")
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("KafkaConsumerServer=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
        System.out.println("KafkaConsumerServer-------------topic:"+topic);
        System.out.println("KafkaConsumerServer-------------value:"+value);
        System.out.println("KafkaConsumerServer-------------key:"+key);
        System.out.println("KafkaConsumerServer-------------offset:"+offset);
        System.out.println("KafkaConsumerServer-------------partition:"+partition);
        System.out.println("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
        System.out.println("消费成功***************************************************************");
    }
}
