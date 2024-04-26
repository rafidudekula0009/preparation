package com.rafi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HelloWorld {

	static Map<String, String> failFast = new HashMap<String, String>();
	static ConcurrentHashMap<String, String> mapConcurrent = new ConcurrentHashMap<>();
	
	public static void main(String args[]) {
		System.out.println("Hello World!!");

		List<Integer> numbers = Arrays.asList(1, 2, 3,107);
		System.out.println("list without squares => "+numbers);
		List<Integer> squares = numbers.stream().map(n->n*n).collect(Collectors.toList());
		System.out.println("list with squares => "+squares);

		LocalDate birthDay = LocalDate.of(1991, 03, 29);
		LocalDate today = LocalDate.now();

		System.out.println(ChronoUnit.YEARS.between(birthDay, today));

		StringBuffer s1=new StringBuffer("Rafi");
		StringBuffer s2=s1;
		System.out.println("S2 Value => "+s2+", "+s1.equals(s2));

		Function<Integer, Integer> square = x->{

			return (x+200)-10;};

			System.out.println(square.apply(100));





			
			failFast.put("rafi", "mca");
			failFast.put("sandhya", "phd");
			failFast.put("ramjan", "phdplus");
			failFast.put("santosh", "fox");
			failFast.put("sarah", "mental");
//			fail();
			
			mapConcurrent.put("rafi", "mca");
			mapConcurrent.put("sandhya", "phd");
			mapConcurrent.put("ramjan", "phdplus");
			mapConcurrent.put("santosh", "fox");
			mapConcurrent.put("sarah", "mental");
			failConcurrent();
			
			List<Integer> numbersList = List.of(1,2,3,4);
			
			int sum = numbersList.stream().filter(number->number%2==0).map(number->number*number).reduce(0, (x,y)->x+y);
			System.out.println("Sum is => "+sum);
			
			System.out.println(numbersList.stream().reduce(0, (x,y)->x+y));

	}

	private static void failConcurrent() {
		mapConcurrent.entrySet().stream().forEach(key->{
			mapConcurrent.entrySet().stream().forEach(key2->{mapConcurrent.put(key2.getKey(), "rummy");});
			mapConcurrent.put(key.getKey(), "dummy");
//			System.out.println(mapConcurrent);
			mapConcurrent.put("new key", "dummy2");
		});
		
		System.out.println(mapConcurrent);
		
	}

	public static void fail() {
		failFast.entrySet().stream().forEach(key->{
			failFast.entrySet().stream().forEach(key2->{failFast.put(key2.getKey(), "rummy");});
			failFast.put(key.getKey(), "dummy");
			failFast.put("new key", "dummy2");
		});
		
		System.out.println(failFast);
	}
}


