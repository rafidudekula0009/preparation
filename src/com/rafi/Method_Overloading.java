package com.rafi;

public class Method_Overloading {

	public static void main(String[] args) {
		
	}
	
	public String return_name(String message) {
		return "rafi";
	}
	public String return_name(String msg, int num) {
		return "rafi";
	}

//	below method is not allowed as method overloading don't consider the return type. 
//	The input parameters must not be same. 
//	There must be some change in type or count
	/*
	 * public int return_name(String msg) { return 1; }
	 */
}
