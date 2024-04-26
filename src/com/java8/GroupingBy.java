package com.java8;

import java.util.List;
import java.util.stream.Collectors;

public class GroupingBy {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring","Framework",98,900),
				new Course("Spring Boot","Framework",99,2000),
				new Course("API","MicroServices",92,300),
				new Course("MicroServices","MicroServices",91,10000),
				new Course("AWS","Cloud",90,900),
				new Course("Azure","Cloud",92,8000)
				);
		//prints as category = [courses list], ... Ex: MicroServices=[Course[name=API,..], Course[Name=MicroServices]]
		System.out.println("grouped by category with data => \n"+courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		
		//{MicroServices=2, Cloud=2, Framework=2}
		System.out.println("\ngrouped by category with count => "+courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
	}
}
