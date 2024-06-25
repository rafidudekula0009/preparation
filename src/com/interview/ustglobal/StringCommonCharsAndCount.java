package com.interview.ustglobal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCommonCharsAndCount {

	public static void main(String[] args) {
		String name1="simityes";
		String name2="mityesaa";
		
		System.out.println("String 1 => "+name1.chars().mapToObj(obj->String.valueOf((char)obj)).sorted().collect(Collectors.toList()));
		System.out.println("String 2 => "+name2.chars().mapToObj(obj->String.valueOf((char)obj)).sorted().collect(Collectors.toList()));
		
		List<String> name1List=name1.chars().mapToObj(obj->String.valueOf((char)obj)).sorted().collect(Collectors.toList());
		List<String> name2List=name2.chars().mapToObj(obj->String.valueOf((char)obj)).sorted().collect(Collectors.toList());
	
		Map<String, Integer> countOfChar=new HashMap<>();
		name1List.stream().forEach(ch->{
			if(name2.contains(ch)) {
				if(countOfChar.get(ch)!=null) {
					countOfChar.put(ch, countOfChar.get(ch)+1);
				}else {
					countOfChar.put(ch, 1);
				}
			}
		});
		
		
		name2List.stream().forEach(ch->{
			if(countOfChar.get(ch)!=null) {
				countOfChar.put(ch, countOfChar.get(ch)+1);
			}
		});
		System.out.println(countOfChar);
	}
}
