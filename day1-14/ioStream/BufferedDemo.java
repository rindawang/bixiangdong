package ioStream;

import java.io.*;

public class BufferedDemo {

	private static final String LINE_SEPORATOR = System.getProperty("line.separator");
	private static final int FILE_SIZE = 4096;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {

			bw = new BufferedWriter(new FileWriter("demo.txt"));
			bw.write("abcedsdlf");
			bw.newLine();
			bw.write("sweew");
			bw.write(LINE_SEPORATOR + "DDDDD");
			
			bw.flush();
			
			br = new BufferedReader(new FileReader("copyDemo.txt"));

			String line = null;
			while((line = br.readLine()) != null){
				
			 System.out.println(line);
			}
			
			

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (bw != null) {
				try {
					bw.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
