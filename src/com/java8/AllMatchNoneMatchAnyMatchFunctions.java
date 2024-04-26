package com.java8;

import java.util.List;
import java.util.function.Predicate;

public class AllMatchNoneMatchAnyMatchFunctions {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,20000),
				new Course("Spring Boot","Framework",99,20000),
				new Course("API","MicroServices",92,20000),
				new Course("MicroServices","MicroServices",91,20000),
				new Course("AWS","Cloud",90,20000),
				new Course("Azure","Cloud",92,20000)
				);
		Predicate<Course> reviewScoreGreaterThan95Predicate = course->course.getReviewScore()>89;
		Boolean result = reviewScoreGreaterThan95Predicate.test(new Course("Spring","Framework",94,20000));
		
		System.out.println(result);
		
		System.out.println("allMatch>98? =>"+courses.stream().allMatch(course->course.getReviewScore()>98));
		System.out.println("allMatch>89 with defined predicate? =>"+courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
		
		System.out.println("noneMatch>98? =>"+courses.stream().noneMatch(course->course.getReviewScore()<98));
		System.out.println("anyMatches>98? =>"+courses.stream().anyMatch(course->course.getReviewScore()>98));
	}
}
