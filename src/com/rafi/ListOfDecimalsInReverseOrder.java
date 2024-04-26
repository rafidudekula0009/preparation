package com.rafi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListOfDecimalsInReverseOrder {
	public static void main(String[] args) 
    {
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
         
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
	
	//o/p
	
	/*
	71.85
	56.98
	42.89
	33.78
	23.58
	21.12
	17.13
	12.45
	*/	
}
