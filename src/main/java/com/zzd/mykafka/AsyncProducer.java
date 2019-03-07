package com.zzd.mykafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author zhangzhidong
 * @create: 2019-03-07 23:13
 */
public class AsyncProducer<K, V> extends BaseProducer<K, V, Boolean> {

    public AsyncProducer(Properties kafkaProperties) {
        super(kafkaProperties);
    }

    @Override
    protected Boolean doSend(ProducerRecord<K, V> record) {
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception != null) {
                    exception.printStackTrace();
                }
            }
        });
        return true;
    }
}
