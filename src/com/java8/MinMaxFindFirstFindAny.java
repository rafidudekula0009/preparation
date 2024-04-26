package com.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MinMaxFindFirstFindAny {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,900),
				new Course("Spring Boot","Framework",99,2000),
				new Course("API","MicroServices",92,300),
				new Course("MicroServices","MicroServices",91,10000),
				new Course("AWS","Cloud",90,900),
				new Course("Azure","Cloud",92,8000)
				);
		//max
		Comparator<Course> compareByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
		System.out.println("Max Students Course => \n"+courses.stream().max(compareByNoOfStudents));
		
		//min
		System.out.println("\nMin Students Course => \n"+courses.stream().min(compareByNoOfStudents));
		
		System.out.println("\nMin Students Course with filter => \n"+courses.stream().filter(course->course.getReviewScore()<89).min(compareByNoOfStudents));
		System.out.println("\nMin Students Course with filter and default value => \n"+courses.stream().filter(course->course.getReviewScore()<89).min(compareByNoOfStudents).orElse(new Course("AWS","Cloud",90,900)));
		
		//FindFirst
		System.out.println("\nFindFirst=> \n"+courses.stream().filter(course->course.getReviewScore()>91).findFirst());
		
		//FindAny
		System.out.println("\nFindAny=> \n"+courses.stream().filter(course->course.getReviewScore()>91).findAny());
		System.out.println(courses.stream().collect(Collectors.toMap(Course::getName, Function.identity())));
		
		Consumer<String> sampleConsumer = x->System.out.print(x);
		sampleConsumer.accept("Hello...");
		
		Supplier<Integer> sampleSupplier = ()->2;
		
		System.out.println(sampleSupplier.get());
	}
}
