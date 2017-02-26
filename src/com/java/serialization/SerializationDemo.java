package com.java.serialization;

import java.io.*;
import java.util.*;

public class SerializationDemo {

	/**
	 * This serialize takes two parameter.
	 * 
	 * @param pList
	 *            is the object that needs to be serialize to bytestream
	 * @param fileName
	 *            bytestream to...
	 */

	public void serialize(List<Participant> pList, String fileName) {
		// java 7 try resource
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(pList);

		} catch (IOException e) {
			System.out.println("A problem occured during serialization.");
			System.out.println(e.getMessage());
		}
	}

	public List<Participant> deserialize(String fileName) {
		List<Participant> pList = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			pList = (List<Participant>) in.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.printf("A problem occured deserializing %s%n", fileName);
			System.out.println(ex.getMessage());
		}

		return pList;
	}
}
