package com.rafi;

import java.util.List;
import java.util.stream.Collectors;

public class NamesWith2ndIndexValueA {

	public static void main(String[] args) {
	
		List<String> names = List.of("Hari","krishna","bala");
		
		System.out.println(
				names.stream()
				.filter(name->name.charAt(1)=='a')
				.collect(Collectors.toList()));
		
		List<Integer> numbers=List.of(1,2,3,4,5,6,7,8);
	}
}
