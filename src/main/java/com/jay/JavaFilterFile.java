package com.jay;

import java.io.File;
import java.io.FileFilter;

public class JavaFilterFile implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.getName().endsWith(".java");
	}

}
