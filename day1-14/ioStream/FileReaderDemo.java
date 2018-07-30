package ioStream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {

		FileReader fr = null;
		try {
			fr = new FileReader("demo.txt");
			/*
			 * int ch = 0; while((ch =fr.read())!= -1){ System.out.println(ch +
			 * "    " + (char)ch); }
			 */
			char[] chArray = new char[3];
			int len = 0;

			while ((len = fr.read(chArray)) != -1) {
				System.out.println(new String(chArray, 0, len));
			}

			/*
			 * System.out.println(fr.read(chArray));
			 * 
			 * System.out.println(new String(chArray));
			 * 
			 * char[] chArray1 = new char[3];
			 * System.out.println(fr.read(chArray1));
			 * 
			 * System.out.println(new String(chArray1));
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
