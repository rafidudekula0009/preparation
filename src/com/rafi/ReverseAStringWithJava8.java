package com.rafi;

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseAStringWithJava8 {
	public static void main(String[] args) {

		String str="rafi";

		IntStream charStream = str.chars();
		
		Stream<String> strStream = charStream.mapToObj(ch ->String.valueOf((char)ch));
		
		BinaryOperator<String> accumulator = (first,second) -> {
			System.out.println("acc=> "+first+", second=> "+second);
			return second+first;
		};
		String reverseString = strStream.reduce(accumulator).orElse("");
		
		System.out.println(reverseString);
	}
}
