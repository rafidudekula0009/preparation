package com.realtime.java8.queries;

import java.util.List;

public class AvgAndTotSalaryOfOrg {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		System.out.println(employeeList.stream().mapToDouble(Employee::getSalary).average());
		System.out.println(employeeList.stream().mapToDouble(Employee::getSalary).sum());
		
		
	}
}
