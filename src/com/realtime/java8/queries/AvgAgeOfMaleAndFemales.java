package com.realtime.java8.queries;

import java.util.List;
import java.util.stream.Collectors;

public class AvgAgeOfMaleAndFemales {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
	}
}
