package ioStream;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

	private String suffix;
	public MyFileFilter(String suffix) {
		super();
		this.suffix = suffix;
	}
	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		
		
		return pathname.getName().endsWith(this.suffix);
	}

}
