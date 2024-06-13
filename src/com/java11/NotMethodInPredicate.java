package com.java11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotMethodInPredicate {

	public static void main(String[] args) {

		List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
		List<String> withoutBlanks = sampleList.stream().filter(Predicate.not(word -> word == "Kotlin"))
				.filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
		System.out.println(withoutBlanks); // Only collected the elements which are not equal to Kotlin and empty string

	}
}
