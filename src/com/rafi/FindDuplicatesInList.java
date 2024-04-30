package com.rafi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicatesInList {

	public static void main(String[] args) {
	
	List<String> names = List.of("rafi","ranjan","rafi","sandhya");
	Set<String> setNames=new HashSet<String>();
	System.out.println(names.stream().filter(name->!setNames.add(name)).collect(Collectors.toList()));
	}
	
}
