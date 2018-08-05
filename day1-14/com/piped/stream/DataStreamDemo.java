package com.piped.stream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataStreamDemo {
	public static void main(String[] args) throws IOException{
/*		DataOutputStream dis = new DataOutputStream(new FileOutputStream("dataoutput.txt"));
		
		dis.writeUTF("你好！！");
		dis.close();*/
		
		DataInputStream dis1 = new DataInputStream(new FileInputStream("dataoutput.txt"));
		System.out.println(dis1.readUTF());
		
		
	}

}
