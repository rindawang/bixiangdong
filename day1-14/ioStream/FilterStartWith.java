package ioStream;

import java.io.File;
import java.io.FilenameFilter;

public class FilterStartWith implements FilenameFilter {
	private String startWith;
	public FilterStartWith(String startWith){
		this.startWith = startWith;
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		
		return name.startsWith(startWith);
	}

}
