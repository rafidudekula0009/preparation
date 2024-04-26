package com.rafi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeperateOddAndEven {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3,107,8,22);
		
		Map<Boolean, List<Integer>>  mapOddEven = numbers.stream().collect(Collectors.partitioningBy(i->i%2==1));
		
		System.out.println(mapOddEven); //{false=[2, 8, 22], true=[1, 3, 107]}
	}
}
