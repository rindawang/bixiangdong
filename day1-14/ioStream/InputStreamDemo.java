package ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream fos = new FileOutputStream("demo.txt");
		fos.write("abcde".getBytes());
		//fos.flush();
		fos.close();
		
		FileInputStream fis = new FileInputStream("demo.txt");
/*		int bt = 0;
		bt = fis.read();
		while((bt = fis.read())!= -1){
			System.out.println((char)bt);
		}*/
/*		byte[] bta = new byte[2046];
		int len = 0;
		while((len = fis.read(bta)) != -1){
			System.out.println(new String(bta, 0, len));
		}*/
		
		byte[] bta = new byte[fis.available()];
		fis.read(bta);
		System.out.println(new String(bta));

		fis.close();

	}

}
