package com.rafi;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharInAString {
	public static void main(String[] args) {
		String name = "Dudekula Mohammed Rafi";

		Map<Character, Long> frequency = name.chars().mapToObj(c->(char)c)
		.collect(Collectors.groupingBy(Function.identity(),
				Collectors.counting()));

		System.out.println(frequency); //{ =2, a=3, d=2, D=1, e=2, f=1, h=1, i=1, k=1, l=1, m=2, M=1, o=1, R=1, u=2}
	}
}
