package com.prajjwal.kafka;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Receiver {

	private static final String TOPIC = "prajjwal_first_topic";
	private static final String GROUP_ID = "prajjwal_first_group";

	public void receive() {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("kafka.topic.name", TOPIC);
		props.setProperty("group.id", GROUP_ID);
		props.setProperty("auto.commit.interval.ms", "1000");
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
			consumer.subscribe(List.of(TOPIC));
			for (int i = 0; i < 1000; i++) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.of(1000, ChronoUnit.MILLIS));
				System.out.println("Size:" + records.count());
				for (ConsumerRecord<String, String> aRecord : records) {
					System.out.println("Received message: " + aRecord.value());
				}
			}
		}

	}
}
