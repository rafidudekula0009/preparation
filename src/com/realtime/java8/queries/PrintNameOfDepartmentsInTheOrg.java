package com.realtime.java8.queries;

import java.util.List;

public class PrintNameOfDepartmentsInTheOrg {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
		employeeList.stream().forEach(System.out::println);
		
		employeeList.stream().map(emp->emp.getDepartment()).distinct().forEach(System.out::println);
	}
}
