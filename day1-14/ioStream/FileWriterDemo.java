package ioStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
	static final String FILE_SEPORATOR = System.getProperty("line.separator");

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("demo.txt",true);
		fw.write("abc");
/*		char[] arrayChar = {'a', 'b'};
		fw.write(FILE_SEPORATOR);
		fw.write(arrayChar);*/
		fw.flush();
		//fw.close();
	}

}
