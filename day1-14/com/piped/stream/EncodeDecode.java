package com.piped.stream;

import java.io.UnsupportedEncodingException;

public class EncodeDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String yuanma = "北京欢迎你！";
		byte[] bt = new byte[1024];
		try {
			bt = yuanma.getBytes();
			System.out.println(new String(bt, "utf-8"));
			String jiema1 = new String(bt, "gbk");
			bt = jiema1.getBytes("gbk");
			String jiema2 = new String(bt, "utf-8");
			System.out.println(jiema2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
