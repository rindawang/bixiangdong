package ioStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EncodeWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gbk_1.txt"), "GBK"));
		bw.write("你好，中文");
		bw.flush();
		bw.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("gbk_1.txt"),"UTF-8"));
		System.out.println(br.readLine());
		br.close();
		
/*		Map<String, Charset> encodetable = Charset.availableCharsets();
		for (Entry<String, Charset> entry : encodetable.entrySet()) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}*/
	}

}
