package com.realtime.java8.queries;

import java.util.Comparator;
import java.util.List;

public class OldestEmpAgeAndDep {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		System.out.println("Age => "+employeeList.stream().max(Comparator.comparing(Employee::getAge)).get().getAge());
		System.out.println("Dept => "+employeeList.stream().max(Comparator.comparing(Employee::getAge)).get().getDepartment());
		System.out.println("Name => "+employeeList.stream().max(Comparator.comparing(Employee::getAge)).get().getName());
		
		
	}
}
