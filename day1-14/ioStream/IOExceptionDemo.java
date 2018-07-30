package ioStream;

import java.io.FileWriter;
import java.io.IOException;

public class IOExceptionDemo {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("K:\\demo.txt");

			fw.write("string");
			fw.write(FileWriterDemo.FILE_SEPORATOR);

		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
		}

	}
}
