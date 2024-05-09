package com.realtime.java8.queries;

import java.util.List;
import java.util.stream.Collectors;

public class CountOfMaleAndFemaleInSalesDept {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		System.out.println(employeeList.stream().filter(emp->emp.getDepartment().equalsIgnoreCase("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
	}
}
