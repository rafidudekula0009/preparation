package com.java11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LocalVariableSyntaxForLambda {

	public static void main(String[] args) {
		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		String resultString = sampleList.stream()
//		  .map((@Nonnull var x) -> x.toUpperCase())
				.map((var x) -> x.toUpperCase())
				.collect(Collectors.joining(", "));
		
		System.out.println(resultString);

	}
}
