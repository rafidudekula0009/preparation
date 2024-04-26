package com.realtime.java8.queries;

import java.util.List;
import java.util.stream.Collectors;

public class SepEmpBelowAndAboveOf25Age {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
//		Map<Integer, Map<Boolean, List<Employee>>> OlderAndYounger = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.partitioningBy(emp->emp.getAge()>25)));
		
		System.out.println(employeeList.stream().collect(Collectors.partitioningBy(emp->emp.age>25)));
		
		
		
	}
}
