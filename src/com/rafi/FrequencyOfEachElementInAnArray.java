package com.rafi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachElementInAnArray {
	public static void main(String[] args) 
	{
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

		Map<String, Long> stationeryCountMap = 
				stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(stationeryCountMap);//{Pen=2, Stapler=1, Pencil=2, Note Book=2, Eraser=1}
	}
}

