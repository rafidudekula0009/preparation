package com.interview.questions;

import java.util.List;
import java.util.stream.Collectors;

public class FindEmpIdWithASpecificProject {

	public static void main(String[] args) {

		List<Employee> listEmployee= List.of(
				new Employee("Rafi_001", "Rafi"),
				new Employee("Ranjan_002", "Ranjan"),
				new Employee("Sandhya_003", "Sandhya"),
				new Employee("Satish_004", "Satish"));
		
		List<Project> listProject= List.of(
				new Project("Rafi", "Spring Boot"),
				new Project("Ranjan", "MicroService"),
				new Project("Sandhya", "Spring Boot"),
				new Project("Satish", "MicroService"));
		
		String projName="MicroService";
		
				
		List<String> empName=listProject.stream()
				.filter(project->project.getProj_name().equals(projName))
				.map(proj->proj.getEmp_name())
				.collect(Collectors.toList());
		System.out.println("Emp Names with \""+projName+"\" project => "+empName);
		
		System.out.println("Emp Ids = > "+listEmployee.stream()
		.filter(emp->empName.contains(emp.getEmp_name()))
		.map(empId->empId.getEmp_id())
		.collect(Collectors.toList()));
		
		
		System.out.println("Emp Ids = > "+listEmployee.stream()
		.filter(emp->(listProject.stream()
				.filter(project->project.getProj_name().equals(projName))
				.map(proj->proj.getEmp_name())
				.collect(Collectors.toList())).contains(emp.getEmp_name()))
		.map(empId->empId.getEmp_id())
		.collect(Collectors.toList()));
	}
}
