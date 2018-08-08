package com.test.java;

public class CN {
	public static final int  CNNUM= 24366826;
	
	public static String isCN(int num) {
		if (num == CNNUM) {
			return "CN";
		}
		return "false";
	}
}
