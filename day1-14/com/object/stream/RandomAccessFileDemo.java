package com.object.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		RandomAccessFile raf = new RandomAccessFile("randomAccess.txt", "r");
		
/*		raf.write("zhangsan".getBytes());
		raf.writeInt(609);*/
		
		byte[] bt = new byte[4];
		raf.read(bt);
		System.out.println(new String(bt));
		raf.read(bt);
		System.out.println(raf.readInt());
		
		raf.seek(24l);
		raf.write("zhaoliu".getBytes());
		
		raf.close();
		

	}

}
