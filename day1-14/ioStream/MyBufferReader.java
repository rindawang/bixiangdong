package ioStream;
/*
 * 自己实现缓冲区方法
 * 从源中取出一批数据，
 * 在此次取光后再从源中取一批。
 * 
 * 
 */

import java.io.*;

public class MyBufferReader {
	private static final int SIZE = 4;
	private FileReader fr;
	private char[] buff = new char[SIZE];
	// 定义一个指针,记录读到的位置。
	private int pos = 0;
	// 定义一个数据记录缓冲区中的数据个数。
	private int left;

	public MyBufferReader(FileReader fr) {
		this.fr = fr;
	}

	public int myRead() throws IOException {

		if (left == 0) {
			left = this.fr.read(buff);
			pos = 0;
		}

		if (left == -1) {
			return -1;
		}
		int result = 0;
		result = buff[pos++];
		left--;

		return result;
	}

	public String myReadLine() throws IOException {
		StringBuilder result = new StringBuilder();
		if (myRead() == -1) {
			return null;
		}
		int ch = 0;
		while ((ch = myRead()) != -1) {
			if (ch == 10)
				continue;
			if (ch == 13)
				return result.toString();
			result.append((char) ch);
		}

		return result.toString();

	}

	public static void main(String[] args) throws IOException {
		MyBufferReader mbr1 = new MyBufferReader(new FileReader("demo.txt"));
		int ch = 0;
		while ((ch = mbr1.myRead()) != -1) {
			System.out.println((char) ch + ch);
		}
		mbr1.fr.close();
		MyBufferReader mbr2 = new MyBufferReader(new FileReader("demo.txt"));
		String line = null;
		while ((line = mbr2.myReadLine()) != null) {
			System.out.println(line);
		}

	}

}
