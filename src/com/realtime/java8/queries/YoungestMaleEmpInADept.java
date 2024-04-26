package com.realtime.java8.queries;

import java.util.Comparator;
import java.util.List;

public class YoungestMaleEmpInADept {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		System.out.println(employeeList.stream()
				.filter(emp->emp.getGender().equals("Male") && emp.getDepartment().equals("Product Development"))
				.min(Comparator.comparing(Employee::getAge)));
	}
}
