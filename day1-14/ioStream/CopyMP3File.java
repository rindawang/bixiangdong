package ioStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMP3File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("alice.mp3");
		FileOutputStream fos = new FileOutputStream("copyAlice4.mp3");
		// copy1(fis, fos);

		// copy2(fis, fos);

		copy3(fis, fos);
		
		//copy4(fis, fos);

	}

	private static void copy4(FileInputStream fis, FileOutputStream fos) throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte bt = 0;

		

		bos.close();
		bis.close();
	}

	private static void copy3(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		// TODO Auto-generated method stub

		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] bta = new byte[bis.available()];
		bis.read(bta);
		bos.write(bta);

		bos.close();
		bis.close();
	}

	private static void copy2(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int bt = 0;
		while ((bt = bis.read()) != -1) {
			bos.write(bt);
		}

		bos.close();
		bis.close();

	}

	private static void copy1(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		// TODO Auto-generated method stub
		byte[] bta = new byte[4096];
		int len = 0;
		while ((len = fis.read(bta)) != -1) {
			fos.write(bta, 0, len);
		}
		fis.close();
		fos.close();
	}

}
