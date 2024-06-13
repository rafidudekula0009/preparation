package com.java11;

import java.util.Arrays;
import java.util.List;

public class CollectionToArray_toArray {

	public static void main(String[] args) {

		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		String[] sampleArray = (String[]) sampleList.toArray(String[]::new); // converts arrayList of Strings to string
																				// array[]
		System.out.println("sampleArray length => " + sampleArray.length + ", " + sampleArray[0]);
//		assertThat(sampleArray).containsExactly("Java", "Kotlin");

	}
}
