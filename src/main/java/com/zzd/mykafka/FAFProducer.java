package com.zzd.mykafka;

import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Fire and Forget Producer
 *
 * @author zhangzhidong
 * @create: 2019-03-07 22:27
 */
public class FAFProducer<K, V> extends BaseProducer<K, V, Boolean> {

    public FAFProducer(Properties kafkaProperties) {
        super(kafkaProperties);
    }

    @Override
    protected Boolean doSend(ProducerRecord record) {
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
