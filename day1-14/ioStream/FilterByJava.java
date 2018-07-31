package ioStream;

import java.io.File;
import java.io.FilenameFilter;

public class FilterByJava implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		
		return name.endsWith(".pdf")|| dir.exists();
	}

}
