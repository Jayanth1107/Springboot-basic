package com.jay;

import java.io.File;
import java.io.FileFilter;

public class AnotherClassForFileFilter {

	public static void main(String args[]) {

		JavaFilterFile filter = new JavaFilterFile();

		File file = new File("C:\\Users\\jayan\\Desktop\\");
		File[] javaFiles = file.listFiles(filter);

		for (File f : javaFiles) {
			System.out.println(f.getName());
		}
		
		
		
		FileFilter filter2 = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		
		File file2 = new File("C:\\Users\\jayan\\Desktop\\");
		File[] javaFiles2 = file2.listFiles(filter2);
		
		for (File f : javaFiles2) {
			System.out.println(f.getName());
		}
		
		
		
		FileFilter filter3 = (File pathname)-> pathname.getName().endsWith(".java");


		File file3 = new File("C:\\Users\\jayan\\Desktop\\");
		File[] javaFiles3 = file3.listFiles(filter3);
		
		for (File f : javaFiles3) {
			System.out.println(f.getName());
		}
		
		MyFunctionalInterface myF = () -> "reast1";
		
		System.out.println(myF.getName());
		System.out.println(MyFunctionalInterface.getNames());
		System.out.println(MyFunctionalInterface.getNames2());
		System.out.println(myF.getNames3());
		System.out.println(myF.getNames4());
	}

}
