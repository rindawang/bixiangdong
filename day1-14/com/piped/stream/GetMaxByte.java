package com.piped.stream;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class GetMaxByte {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		String encode = "utf-8";
		byte[] buf = "ab你好cde我好".getBytes(encode);
		int cutpos = 7;
		String cutted = cutString(buf, cutpos, encode);

		for (int i = 0; i < 17; i++) {
			cutpos = i + 1;
			System.out.println("前" + cutpos + "個是： " + cutString(buf, cutpos, encode));
		}
	}

	private static String cutString(byte[] buf, int cutpos, String encode) throws IOException {
		// TODO Auto-generated method stub

		int numberOfMi = 0;
		if (encode.equals("gbk")) {
			if ((int) buf[cutpos - 1] < 0) {
				for (int i = 0; i < cutpos; i++) {
					if ((int) buf[i] < 0) {
						numberOfMi++;
					}
				}
				if (numberOfMi % 2 != 0) {
					cutpos--;
				}
			}

			return new String(Arrays.copyOfRange(buf, 0, cutpos), encode);
		} else if (encode.equals("utf-8")) {
			if ((int) buf[cutpos - 1] < 0) {
				for (int i = 0; i < cutpos; i++) {
					if ((int) buf[i] < 0) {
						numberOfMi++;
					}
				}
				if (numberOfMi % 3 == 1) {
					cutpos--;
				}
				if (numberOfMi % 3 == 2) {
					cutpos = cutpos - 2;
				}
			}
			return new String(Arrays.copyOfRange(buf, 0, cutpos), encode);
		}
		return null;
	}

}
