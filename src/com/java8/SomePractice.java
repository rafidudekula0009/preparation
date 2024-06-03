
package com.java8;

import java.util.List;

public class SomePractice {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(15,11,17,1,19);
		
		System.out.println(numbers.stream().sorted().skip(1).findFirst());
	}
}
