package com.rafi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedParanthesisOfString2 {   
	public static void main(String[] args) {
		
		
//		String braceString="{{[])}}";
		 String braceString;   
         
	        // create an instance of Scanner class   
	        Scanner sc = new Scanner(System.in);   
	          
	        System.out.println("Enter input string to check example-({{[])}}):");   
	        // take input sring from user   
	        braceString = sc.nextLine();   
		
		List<String> finalBraces=braceString.chars().mapToObj(c ->String.valueOf((char) c)).collect(Collectors.toList());
		
		List<Braces> finalBraceList=new ArrayList<Braces>();
		finalBraces.stream().forEach(brace->{
			String result=findCombination(brace, finalBraces);
			if(result!="") {
				finalBraceList.add(new Braces(result,""));
			}
		});
		
		System.out.println("Count=>"+finalBraceList.stream().collect(Collectors.groupingBy(Braces::getBrace, Collectors.counting())));
	}
	
	static String findCombination(String current, List<String> bracesList){
		
		switch (current) {   
        case ")":   
          
        if (bracesList.contains("("))   
            return "()";   
        break;   
        case "}":   
        	 if (bracesList.contains("{"))   
                 return "{}";
        break;   
        case "]":   
        	if (bracesList.contains("["))   
                return "[]";
        break;   
    }
	return "";   
	}
}  