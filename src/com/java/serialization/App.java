package com.java.serialization;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Participant> participants = new ArrayList<>();
		participants.add(new Participant("Ben", "Smith", 17));
		participants.add(new Participant("Melinda", "Green", 20));

		participants.add(new Participant("Michael", "Thomas", 21));

		participants.add(new Participant("Julia", "Webster", 19));
		System.out.println(participants);
		SerializationDemo demo = new SerializationDemo();
		try {
			demo.serialize(participants, "src/com/java/serialization/Participants.ser");

		} catch (Exception e) {
			System.out.println("Error in saving in file.");
			System.out.println(e.getMessage());
		}
		System.out.println("Serialization done");
		List<Participant> newList = demo.deserialize("src/com/java/serialization/Participants.ser");
		System.out.println("New List :" + newList);
	}

}
