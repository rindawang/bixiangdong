package ioStream;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*		demo_FileConstructor();
		demo_FileAttibutes();
		demo_FileCreateAndDelete();
		demo_FileCheck();
		demo_Rename();
		demo_listRoot();
		demo_listFilter();*/
		demo_deepSearch();
		

	}

	private static void demo_deepSearch() {
		// TODO Auto-generated method stub
		File path = new File("D:\\技术书pdf");
		Map<File, String> fileList = new LinkedHashMap<>(); 
		//获取当前目录的所有文件或文件夹
		String level = "";
		
		recursionPath(path, fileList, level);
		for(Entry<File, String> f: fileList.entrySet()){
			System.out.println(f.getValue()+ f.getKey().getName());
		}
		
	}
	
	private static void recursionPath(File file, Map<File, String> list, String level){
		if(file.isFile()){
			list.put(file, level);
		}else{
			list.put(file, level);
			level += "-";
			for(File f: file.listFiles()){
				recursionPath(f, list, level);
			}
		}
	}

	private static void demo_listFilter() {
		// TODO Auto-generated method stub
		File path = new File("D:\\技术书pdf");
		File[] fileList = null;
		if(path.exists() && path.isDirectory()){
			//fileList = path.listFiles(new FilterByJava());
			fileList = path.listFiles(new MyFileFilter("pdf"));
		}
		for(File f : fileList){
			System.out.println(f.getAbsolutePath());
		}
		
		
		
	}

	private static void demo_listRoot() {
		// TODO Auto-generated method stub
		File[] files = File.listRoots();
		long maxSpace = 0;
		File maxFile = null;
		for(File file: files){
			System.out.println(file.getAbsolutePath() + file.getFreeSpace() + file.getTotalSpace() + file.getUsableSpace());
			if(file.getFreeSpace() > maxSpace){
				maxSpace = file.getFreeSpace();
				maxFile = file;
			}
		}
		
		System.out.println(maxFile.getAbsolutePath());
		String[] fileList = maxFile.list();
		for(String filename : fileList){
			System.out.println(filename);
		}
		
	}

	private static void demo_Rename() {
		// TODO Auto-generated method stub
		File oldFile = new File("demoRename.txt");
		File newFile = new File("../demoRename.txt");
		oldFile.renameTo(newFile);		
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
