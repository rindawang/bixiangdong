package ioStream;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		InputStream in = System.in;
		//test

		/*
		 * byte[] bt = new byte[4096]; int len = 0; String result = null; while
		 * ((len = in.read(bt)) != -1) { result = new String(bt, 0, len);
		 * 
		 * if(result.equals("over\r\n")) break;
		 * 
		 * System.out.println(result.toUpperCase()); }
		 */
		
		StringBuilder sb = new StringBuilder();

		int bt = 0;
		while ((bt = in.read()) != -1) {
			if (bt == '\r') {
				continue;
			}

			if (bt == '\n') {
				if (sb.toString().equals("over")) {
					break;
				} else {
					System.out.println(sb.toString().toUpperCase());
					sb = new StringBuilder();
				}
			}

			sb.append((char) bt);
		}

	}
}
