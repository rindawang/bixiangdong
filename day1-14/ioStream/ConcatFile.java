package ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcatFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File path = new File("C:\\Users\\i323521\\git\\repository\\day1-14");
		String[] subFile = path.list(new FilterStartWith("MySQL.pdf_part"));
		List<FileInputStream> list = new ArrayList<>();
		FileInputStream fis = null;
		for (String s : subFile) {
			fis = new FileInputStream(s);
			list.add(fis);
		}
		SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(list));
		PrintStream ps = new PrintStream("conbinedFile555.pdf");

		byte[] bt = new byte[1024];
		int length = 0;
		while ((length = sis.read(bt)) > -1) {
			ps.write(bt, 0, length);
			ps.flush();
		}
		sis.close();
		ps.close();
	}

}
