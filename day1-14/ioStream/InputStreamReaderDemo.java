package ioStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * InputStream is = new FileInputStream("demo.txt"); InputStreamReader
		 * isr = new InputStreamReader(is); BufferedReader br = new
		 * BufferedReader(isr);
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * OutputStream os = new FileOutputStream("dmocopy.txt");
		 * OutputStreamWriter osw = new OutputStreamWriter(os); BufferedWriter
		 * bw = new BufferedWriter(osw);
		 */
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("to.txt")));

		String line = null;
		while ((line = br.readLine()) != null) {
			if (!line.equals("over")) {
				bw.write(line.toUpperCase());
				bw.newLine();
				bw.flush();
			} else {
				break;
			}
		}

	}

}
