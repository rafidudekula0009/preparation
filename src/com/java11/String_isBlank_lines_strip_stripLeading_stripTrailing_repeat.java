package com.java11;

import java.util.List;
import java.util.stream.Collectors;

public class String_isBlank_lines_strip_stripLeading_stripTrailing_repeat {

	public static void main(String[] args) {

		String multilineString = "Baeldung helps \n \n developers \n explore Java.";
		List<String> lines = multilineString.lines() // Returns a stream of lines extracted from this string,separated
														// by line terminators.
				.filter(line -> !line.isBlank()) // Returns true if the string is empty or contains only white space
													// codepoints,otherwise false.
				.map(String::strip) // Returns a string whose value is this string, with all leadingand trailing
									// white spaceremoved.
				.collect(Collectors.toList());

		multilineString.lines()
				.forEach(result -> System.out.println("data of the string after using .lines => " + result));
		System.out.println(
				"\noutput of string with \\n to list with \"lines\", and \"strip\" and \"isBlank\" combination => \n"
						+ lines);

		String str = "Abc";

		System.out.println("\n string repeat => " + str.repeat(3)); // o/p : AbcAbcAbc //Returns a string whose value is
																	// the concatenation of
		// thisstring repeated count times. If this string is empty or count is zero
		// then the emptystring is returned.

	}
}
