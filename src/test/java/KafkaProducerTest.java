import com.zzd.mykafka.AsyncProducer;
import com.zzd.mykafka.FAFProducer;
import com.zzd.mykafka.SyncProducer;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * @author zhangzhidong
 * @create: 2019-03-07 22:34
 */
public class KafkaProducerTest {

    private Properties properties;

    @Before
    public void prepareProperties() {
        Properties p = new Properties();
        p.setProperty("bootstrap.servers", "127.0.0.1:9092");
        p.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        p.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.properties = p;
    }

    @Test
    public void testFafProducer() {
        FAFProducer<String, String> fafProducer = new FAFProducer<>(properties);

        Boolean send = fafProducer.send("CustomerCountry", "Precision Products", "China");
        System.out.println(send);
        while (true) {

        }
    }

    @Test
    public void testSyncProducer() {
        SyncProducer<String, String> syncProducer = new SyncProducer<>(properties);

        Object send = syncProducer.send("CustomerCountry", "Precision Products", "France");
        System.out.println(send);

    }

    @Test
    public void testAsyncProducer() {
        AsyncProducer<String, String> asyncProducer = new AsyncProducer<>(properties);

        Boolean send = asyncProducer.send("CustomerCountry", "Biomedical Materials", "USA");
        System.out.println(send);
        while (true) {

        }
    }
}
