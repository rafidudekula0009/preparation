package com.java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndCreateComparator {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,900),
				new Course("Spring Boot","Framework",99,2000),
				new Course("API","MicroServices",92,300),
				new Course("MicroServices","MicroServices",91,10000),
				new Course("AWS","Cloud",90,900),
				new Course("Azure","Cloud",92,8000)
				);
		
		Comparator<Course> compareByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
		System.out.println("Sorted By No Of Students => \n"+courses.stream().sorted(compareByNoOfStudents).collect(Collectors.toList()));
		
		Comparator<Course> compareByNoOfStudentsWithPrimitiveTypes = Comparator.comparingInt(Course::getNoOfStudents);
		System.out.println("Sorted By No Of Students with primitive types => \n"+courses.stream().sorted(compareByNoOfStudentsWithPrimitiveTypes).collect(Collectors.toList()));
		
		Comparator<Course> compareByNoOfStudentsAndReviews = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
		System.out.println("\nSorted By No Of Students and Reviews => \n"+courses.stream().sorted(compareByNoOfStudentsAndReviews).collect(Collectors.toList()));
		
		Comparator<Course> compareByNoOfStudentsAndReviewsWithDescendingOrder = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
		System.out.println("\nSorted By No Of Students and Reviews in descending order => \n"+courses.stream().sorted(compareByNoOfStudentsAndReviewsWithDescendingOrder).collect(Collectors.toList()));
	}
}
