package com.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SkipLimitTakeWhileDropWhile {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,900),
				new Course("Spring Boot","Framework",99,2000),
				new Course("API","MicroServices",92,300),
				new Course("MicroServices","MicroServices",91,10000),
				new Course("AWS","Cloud",90,900),
				new Course("Azure","Cloud",92,8000)
				);
		//skip. It will skip first 4 elements in the list
		Comparator<Course> compareByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
		System.out.println("Skip => \n"+courses.stream().skip(4).max(compareByNoOfStudents));

		//limit. It will take only the number of elem's mentioned in the limit. here 3 elements.
		System.out.println("Limit => \n"+courses.stream().limit(3).max(compareByNoOfStudents));

		//takeWhile. It will take the elements during iteration till the condition satisfies
		System.out.println("TakeWhile => \n"+courses.stream().takeWhile(course->course.getNoOfStudents()<2100).collect(Collectors.toList()));

		//dropWhile. It will not consider till the condition satisfies. once satisfies then it will consider all other elements in the list
		System.out.println("DropWhile => \n"+courses.stream().dropWhile(course->course.getNoOfStudents()<2100).collect(Collectors.toList()));
	}
}
