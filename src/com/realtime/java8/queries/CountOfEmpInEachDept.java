package com.realtime.java8.queries;

import java.util.List;
import java.util.stream.Collectors;

public class CountOfEmpInEachDept {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);

		System.out.println(employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
	}
}
