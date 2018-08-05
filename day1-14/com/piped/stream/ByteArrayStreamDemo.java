package com.piped.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ByteArrayInputStream bais = new ByteArrayInputStream("abcd:你好".getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] bt = new byte[1024];
		int len = 0;
		while((len=bais.read(bt))>-1){
			System.out.println(new String(bt, 0 , len));
		}

		baos.write(bt);
		System.out.println(baos.toString());
	}

}
