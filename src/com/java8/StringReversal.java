package com.java8;

import java.util.Arrays;
import java.util.Scanner;

public class StringReversal {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		System.out.println("input is :: "+input);
		
		String reversal = input.chars().mapToObj(inp -> String.valueOf((char)inp)).reduce((x,y)->y+x).orElse("");
		
		System.out.println("Reversed String is :: "+reversal);
		
		
		//INPUT :: hey is this you , OUTPUT :: you this is hey
		String[] strArray = input.split(" ");
		
		String reversalArray  = Arrays.stream(strArray).reduce((x,y)->y+" "+x).orElse("");
		System.out.print("reversalArray is :::   "+reversalArray);
		
		
	}

}
