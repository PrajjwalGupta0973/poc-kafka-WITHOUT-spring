package com.prajjwal.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class Sender {

	public void send100DummyMessage() throws InterruptedException {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("kafka.topic.name", "prajjwal_first_topic");

		KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props, new StringSerializer(),
				new ByteArraySerializer());
		try (producer) {
			for (int i = 0; i < 10; i++) {
				byte[] message = ("Message number " + i).getBytes();
				ProducerRecord<String, byte[]> producedMessage = new ProducerRecord<>(
						props.getProperty("kafka.topic.name"), message);
				producer.send(producedMessage);
				Thread.sleep(1000);
			}
		}
	}
}
