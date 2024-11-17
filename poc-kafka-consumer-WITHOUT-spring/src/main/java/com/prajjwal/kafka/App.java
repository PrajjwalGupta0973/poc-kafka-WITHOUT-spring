package com.prajjwal.kafka;

public class App {

	public static void main(String[] args) throws InterruptedException {

		Receiver receiver = new Receiver();
		receiver.receive();
	}

}
