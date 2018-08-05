package com.object.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {
	public static void main(String[] args) throws IOException, IOException{
		ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("obj.object"));
		
		ois.writeObject(new Person("ming", 12));
		ois.writeObject(new Person("nini", 13));
		
		ois.close();
	}

}
