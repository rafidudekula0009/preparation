package com.interview.ustglobal;

import java.util.stream.Stream;

public class SumOfNumsInsideAString {

	static int sum=0;
	public static void main(String[] args) {

		String input = "My 90 name 10 is 50 Ramjan"; //find sum of nums in this string

		String[] inputArray = input.split(" ");

		Stream.of(inputArray).filter(SumOfNumsInsideAString::isNumber).forEach(System.out::println);
		System.out.println("Sum=> "+sum);
	}

	public static boolean isNumber(String str) {

		try {
			Double num = Double.parseDouble(str);
			sum+=num;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}