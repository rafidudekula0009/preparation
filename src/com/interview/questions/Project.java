package com.interview.questions;

public class Project {
	String emp_name;
	String proj_name;


	public Project(String emp_name, String proj_name) {
		super();
		this.emp_name = emp_name;
		this.proj_name = proj_name;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public String getProj_name() {
		return proj_name;
	}


	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}


	@Override
	public String toString() {
		return "Project [emp_name=" + emp_name + ", proj_name=" + proj_name + "]";
	}



}
