package ioStream;

import java.io.*;

public class FileCopy {

	private static final int FILE_SIZE = 4096;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;

		try {
			fr = new FileReader("demo.txt");
			fw = new FileWriter("copyDemo.txt");
			
			char[] chArray = new char[FILE_SIZE];
			int len = 0;
			while((len = fr.read(chArray)) != -1){
				fw.write(chArray, 0, len);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (fw != null)
				try {
					fw.close();

				} catch (Exception e2) {
					// TODO: handle exception
				}
		}

	}

}
