package com.zzd.mykafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author zhangzhidong
 * @create: 2019-03-07 22:16
 */
public abstract class BaseProducer<K, V, R> {

    protected KafkaProducer producer;

    protected Properties prop;

    public BaseProducer(Properties kafkaProperties) {
        this.prop = kafkaProperties;
        this.producer = new KafkaProducer<K, V>(kafkaProperties);
    }

    public R send(String topic, K key, V value) {
        ProducerRecord<K, V> record = new ProducerRecord<>(topic, key, value);
        return doSend(record);
    }

    protected abstract R doSend(ProducerRecord<K, V> record);

}
