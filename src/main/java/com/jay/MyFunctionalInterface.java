package com.jay;
@FunctionalInterface
public interface MyFunctionalInterface {
	public String getName();
	public static String getNames() {
		return "dasds1";
	}
	public static String getNames2() {
		return "dasds2";
	}
	public default String getNames3() {
		return "adsdsasa1";
	}
	public default String getNames4() {
		return "adsdsasa2";
	}	
}
