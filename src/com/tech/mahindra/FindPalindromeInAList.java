package com.tech.mahindra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//input : ["dog", "hello", "desserts", "test", "god", "stressed"]
//	output: [[god, dog], [stressed, desserts]];
public class FindPalindromeInAList {

	public static void main(String[] args) {
		List<String> names = List.of("dog", "hello", "desserts", "test", "god", "stressed");
		List<List<String>> palindromeList = new ArrayList<>();
		List<String> processedItem=new ArrayList<String>();
		System.out.println("List of items and its palindromes => \n"+names.stream().filter(name -> {
			String reversedString=getReverse(name);
			if (names.contains(reversedString)) {
				List<String> tempList=List.of(name,reversedString);
				
				if(!processedItem.contains(name) | !processedItem.contains(reversedString)) {
					palindromeList.add(tempList);	
				}
				processedItem.add(name);
				processedItem.add(reversedString);
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList()));
		System.out.println("\nSegregated List with individual palindromes => \n"+palindromeList);
	}

	public static String getReverse(String name) {
		return Stream.of(name.split("")).reduce("", (a, b) -> b + a);
	}
}
