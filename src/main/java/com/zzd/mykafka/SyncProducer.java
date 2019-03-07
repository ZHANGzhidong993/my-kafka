package com.zzd.mykafka;

import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangzhidong
 * @create: 2019-03-07 23:08
 */
public class SyncProducer<K, V> extends BaseProducer<K, V, Object> {

    public SyncProducer(Properties kafkaProperties) {
        super(kafkaProperties);
    }

    @Override
    protected Object doSend(ProducerRecord record) {
        try {
            return producer.send(record).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
