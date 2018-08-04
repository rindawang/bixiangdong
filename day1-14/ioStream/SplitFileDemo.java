package ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SplitFileDemo {

	private static final int SIZE = 1024 * 1024;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "MySQL.pdf";
		String suffix = "_part";
		File originFile = new File(fileName);
		if(!originFile.exists() || !originFile.isFile()){
			System.exit(0);
		}
		FileInputStream fis = new FileInputStream(originFile);
		
		int count = 1;
		byte[] content = new byte[SIZE];
		int length = 0;
		while((length = fis.read(content))>-1){
			File newFile = new File(fileName + suffix + count);
			newFile.createNewFile();
			PrintStream ps = new PrintStream(newFile);
			ps.write(content, 0, length);
			ps.close();
			count++;
		}
		fis.close();
	}

}
