package com.tech.mahindra;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Should revers the string but the special char's position should remain same at same index.
//Should revers only the non special characters
public class ReverseAStringWithSpecialChars {

	public static void main(String[] args) {
		String input = "Swa$pn&il"; //output: lin$pa&wS

		String inputWithoutSpecialChars;
		Map<Integer, String> spclCharIndexMap = new HashMap<Integer, String>();
		inputWithoutSpecialChars = Stream.of(input.split("")).filter(ch -> {
			if (!Character.isDigit(ch.charAt(0))
		            && !Character.isLetter(ch.charAt(0))
		            && !Character.isWhitespace(ch.charAt(0))) {
				spclCharIndexMap.put(input.indexOf(ch), ch);
				return false;
			} else {
				return true;
			}
		}).collect(Collectors.joining());

		System.out.println(spclCharIndexMap);
		inputWithoutSpecialChars = Stream.of(inputWithoutSpecialChars.split("")).reduce("", (a, b) -> b + a);

		for (Entry<Integer, String> s : spclCharIndexMap.entrySet()) {
			inputWithoutSpecialChars = addChar(inputWithoutSpecialChars, (s.getValue()).charAt(0), s.getKey());
		}

		System.out.println(inputWithoutSpecialChars);
	}

	public static String addChar(String str, char ch, int position) {
		int len = str.length();
		char[] updatedArr = new char[len + 1];
		str.getChars(0, position, updatedArr, 0);
		updatedArr[position] = ch;
		str.getChars(position, len, updatedArr, position + 1);
		return new String(updatedArr);
	}
}
