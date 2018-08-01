package ioStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Factor4Deside {

	public static void main(String[] args) throws IOException {
        //需求一：复制文本文件
/*		BufferedReader br = new BufferedReader(new FileReader("demo.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("copy111.txt"));*/
		
		//需求二：键盘录入，写入文件
/*		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new FileWriter("copy111.txt"));*/
		
		//需求三： 文本文件显示在控制台
/*		BufferedReader br = new BufferedReader(new FileReader("demo.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));*/
		
		//需求四：键盘录入，显示在控制台
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		String line = null;
		while((line = br.readLine())!= null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
