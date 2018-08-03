package ioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis1 = new FileInputStream("bufferCopy.txt");
		FileInputStream fis2 = new FileInputStream("copy111.txt");
		FileInputStream fis3 = new FileInputStream("alice.mp3");
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		

	}

}
