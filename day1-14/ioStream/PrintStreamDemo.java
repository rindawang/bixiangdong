package ioStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamDemo {

	public static void main(String[] args) throws IOException{
		PrintStream  stringCon = new PrintStream("stringCon.txt");
		stringCon.append('a');
		stringCon.print("abccabde");
		stringCon.write(97);
		stringCon.print(97);
		
		stringCon.close();
		
		File f = new File("fileCon.txt");
		PrintStream fileCon = new PrintStream(f);
		fileCon.println(123);
		fileCon.close();
		
		BufferedReader fr = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out1 = new PrintWriter("out1.txt");
		PrintWriter out2 = new PrintWriter(System.out, true);
		PrintWriter out3 = new PrintWriter(new FileWriter("out3.txt"));
		PrintWriter out4 = new PrintWriter(new File("out4.txt"));

		String line = null;
		while((line = fr.readLine())!= null){
			out2.println(line.toUpperCase());
			//out2.flush();
		}
		 
		out1.close();
		out3.close();
		out4.close();
	}
}
