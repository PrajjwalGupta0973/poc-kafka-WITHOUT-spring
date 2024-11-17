package com.prajjwal.kafka;

public class App {

	public static void main(String[] args) throws InterruptedException {

		Sender messageSender = new Sender();
		messageSender.send100DummyMessage();
		
		System.out.println("100 message sent");

	}

}
