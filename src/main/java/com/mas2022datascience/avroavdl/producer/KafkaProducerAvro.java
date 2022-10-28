package com.mas2022datascience.avroavdl.producer;

import com.mas2022datascience.avro.v1.Frame;
import java.util.Properties;

import org.apache.kafka.clients.producer.*;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

public class KafkaProducerAvro {

    private final static String TOPIC = "test-java-avro-idl-topic";
    private final static String BOOTSTRAP_SERVERS =
            "dataplatform:9092, dataplatform:9093, dataplatform:9094";
    private final static String SCHEMA_REGISTRY_URL = "http://dataplatform:8081";

    private static Producer<String, Frame> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        //props.put(KafkaAvroSerializerConfig.AUTO_REGISTER_SCHEMAS, "false");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL);   // use constant for "schema.registry.url"

        return new KafkaProducer<>(props);
    }

    static void runProducer(final int sendMessageCount, final int waitMsInBetween, final long id) throws Exception {
        final Producer<String, Frame> producer = createProducer();
        long time = System.currentTimeMillis();

        try {

        } finally {

        }
    }

    public static void main(String... args) throws Exception {
        if (args.length == 0) {
            runProducer(100,10,0);
        } else {
            runProducer(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Long.parseLong(args[2]));
        }
    }
}