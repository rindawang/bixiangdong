package com.object.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.object"));
		Person p = null;
		try {
			while ((p = (Person) ois.readObject()) != null) {
				System.out.println(p.toString());

			}
		} catch (IOException e) {
			// TODO: handle exception
			//e.printStackTrace();
		}
	}

}
