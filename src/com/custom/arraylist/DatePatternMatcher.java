package com.custom.arraylist;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DatePatternMatcher {
	public static void main(String[] args) {
		// Creating a pattern for a simple date format: YYYY-MM-DD
        Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

        // Getting the match predicate from the pattern
        Predicate<String> dateMatcher = datePattern.asMatchPredicate();

        // Creating a stream of date strings and filtering them using the match predicate
        Stream.of("2023-09-27", "12-34-5678", "2021-05-15", "abcd-efgh-ijkl")
              .filter(dateMatcher)
              .forEach(System.out::println);
		
	}
}
