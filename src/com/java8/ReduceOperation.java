package com.java8;

import java.util.List;

public class ReduceOperation {

	public static void main(String[] args) {
		List<Integer> numbersList = List.of(-13,1,4,3,2);
		
		int sum = numbersList.stream().filter(number->number%2==0).map(number->number*number).reduce(0, (x,y)->x+y);
		System.out.println("Sum of squares of even no's is => "+sum);
		
		System.out.println("Sum of elements is => "+numbersList.stream().reduce(0, (x,y)->x+y));
		
		System.out.println("min => "+numbersList.stream().reduce(0, (x,y)->x>y?y:x));
		
		System.out.println("max => "+numbersList.stream().reduce(0, (x,y)->x>y?x:y));
	}
}
