package com.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SumAvgCount {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,900),
				new Course("Spring Boot","Framework",99,2000),
				new Course("API","MicroServices",92,300),
				new Course("MicroServices","MicroServices",91,10000),
				new Course("AWS","Cloud",90,900),
				new Course("Azure","Cloud",92,8000)
				);
		//sum
		Comparator<Course> compareByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
		System.out.println("sum => "+courses.stream().filter(course->course.getNoOfStudents()>2000).mapToInt(Course::getReviewScore).sum());
		
		System.out.println("sum with reduce => "+courses.stream().filter(course->course.getNoOfStudents()>2000).mapToInt(Course::getReviewScore).reduce(0, Integer::sum));

		//count
		System.out.println("count => "+courses.stream().filter(course->course.getNoOfStudents()>2000).count());

		//average
		System.out.println("avg => "+courses.stream().filter(course->course.getNoOfStudents()>2000).mapToInt(Course::getReviewScore).average());
	}
}
