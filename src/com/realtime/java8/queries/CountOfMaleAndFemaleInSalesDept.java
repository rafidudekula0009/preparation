package com.realtime.java8.queries;

import java.util.Comparator;
import java.util.List;

public class CountOfMaleAndFemaleInSalesDept {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		System.out.println(employeeList.stream().filter(emp->emp.getDepartment().equalsIgnorCase("sales")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
	}
}
