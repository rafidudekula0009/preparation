package com.realtime.java8.queries;

import java.util.Comparator;
import java.util.List;

public class HighestPaidEmpInTheOrg {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		System.out.println(employeeList.stream().max(Comparator.comparing(Employee::getSalary)));
	}
}
