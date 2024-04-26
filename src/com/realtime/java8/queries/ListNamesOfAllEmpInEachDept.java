package com.realtime.java8.queries;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListNamesOfAllEmpInEachDept {

	public static void main(String[] args) {
		List<Employee> employeeList = EmployeeListOfData.getEmployeeData();
//		employeeList.stream().forEach(System.out::println);
		
		Map<String, List<Employee>> empMap = employeeList.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment));
		
		empMap.entrySet().stream().forEach(ma->System.out.println(ma.getValue()));
		
	}
}
