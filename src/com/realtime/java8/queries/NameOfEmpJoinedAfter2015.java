package com.realtime.java8.queries;

import java.util.List;

public class NameOfEmpJoinedAfter2015 {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		employeeList.stream().filter(emp->emp.getYearOfJoining()>2015).map(emp->emp.getName()+", joing year = "+emp.getYearOfJoining()).forEach(System.out::println);
	}
}
