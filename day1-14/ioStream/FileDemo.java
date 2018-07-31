package ioStream;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*		demo_FileConstructor();
		demo_FileAttibutes();
		demo_FileCreateAndDelete();*/
		demo_FileCheck();

	}

	private static void demo_FileCheck() {
		// TODO Auto-generated method stub
		File path = new File("C:\\Users\\mami\\git\\bixiangdong\\day1-14");		
		File file = new File(path, "demo.txt");
		System.out.println(file.exists());
		System.out.println(file.mkdir());
		}

	private static void demo_FileCreateAndDelete() throws IOException {
		// TODO Auto-generated method stub
		File path = new File("C:\\Users\\mami\\git\\bixiangdong\\day1-14\\mulu");
		
		boolean pathCr = path.mkdirs();
		
		File file = new File(path, "demo.txt");
		
		boolean isCreated = file.createNewFile();
/*		boolean isDeleted = file.delete();
		boolean pathDel = path.delete();*/
		
	}

	private static void demo_FileAttibutes() {
		// TODO Auto-generated method stub
		File path = new File("C:\\Users\\mami\\git\\bixiangdong\\day1-14");
		File file = new File("demo.txt");
		
		
		String name= file.getName();
		long size = file.length();
		String filepath = file.getPath();
		String fileAbsPath = file.getAbsolutePath();
		Date lastModified = new Date(file.lastModified());
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String  date= df.format(lastModified);		
		
		System.out.println(name);
		System.out.println(size);
		System.out.println(filepath);
		System.out.println(fileAbsPath);
		System.out.println(date);
		
		
	}

	private static void demo_FileConstructor() {
		// TODO Auto-generated method stub
		File f1 = new File("demo.txt");
		File f2 = new File("C:\\Users\\mami\\git\\bixiangdong\\day1-14",
				"demo.txt");
		File path = new File("C:\\Users\\mami\\git\\bixiangdong\\day1-14");
		File f3 = new File(path, "demo.txt");
		System.out.println("shuvhu" + File.pathSeparator + File.separator);
		
		System.out.println();
	}

}
