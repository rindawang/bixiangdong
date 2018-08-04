package ioStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis1 = new FileInputStream("bufferCopy.txt");
		FileInputStream fis2 = new FileInputStream("copy111.txt");
		FileInputStream fis3 = new FileInputStream("gbk_1.txt");
		SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
		
/*		Vector<FileInputStream> vec = new Vector<>();
		vec.add(fis1);
		vec.add(fis2);
		vec.add(fis3);*/
		
		List<FileInputStream> list = new ArrayList<>();
		list.add(fis1);
		list.add(fis2);
		list.add(fis3);
		
		
		Iterator<FileInputStream> it = list.iterator();
		
		Enumeration<FileInputStream> enum1 = Collections.enumeration(list);
/*		Enumeration<FileInputStream> enum1 = new Enumeration<FileInputStream>(){

			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				// TODO Auto-generated method stub
				return it.next();
			}
		};*/
		SequenceInputStream sis2 = new SequenceInputStream(enum1);
		BufferedReader bis = new BufferedReader(new InputStreamReader(sis2));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("comb.txt"));
		String f = null;
		while((f = bis.readLine())!= null){
			bw.write(f);
			bw.newLine();
			bw.flush();
		}
		
		sis2.close();
		bw.close();
		

	}

}
