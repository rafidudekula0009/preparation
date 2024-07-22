package com.rafi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {
	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList("rafi","aboo","praci","rafi","siva","vinod");

		List<String> distinctList = listOfNames.stream().distinct().collect(Collectors.toList());

		System.out.println("Actual List => "+listOfNames);	//Actual List => [rafi, aboo, praci, rafi, siva, vinod]
		System.out.println("List with distinct elements => "+distinctList);	//List with distinct elements => [rafi, aboo, praci, siva, vinod]
	}
}
