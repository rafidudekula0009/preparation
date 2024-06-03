package com.java8;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
 
public class MinOperationOnIntegerList {
    public static void main(String[] args) 
    {
        List<Integer> list = Arrays.asList(2, 3, 1, 4, 5, 6, 7, 8, 9, 10);
 
        Optional<Integer> min;
        Comparator<? super Integer> comparator = (a, b) -> {
        	System.out.println("current elements a => "+a+", b=> "+b+", a-b => "+(a-b));
        	return a -b;
        };
		min = list
                .stream()
                .min(comparator);
		
        System.out.println("The list is " + list);
        System.out.println("Minumum value of the list is " + min.get());
        System.out.println("Maximum value of the list is " + list
                .stream()
                .max(comparator).get());
    }
}