package ioStream;

import java.io.*;

public class CopyWithBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader("copyDemo.txt"));
			bw = new BufferedWriter(new FileWriter("bufferCopy.txt"));

			String s = null;

			while ((s = br.readLine()) != null) {

				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			throw new RuntimeException("error");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
