package com.rafi;

public class CustomObjectStudent {

	private String name;
	private String age;
	private String rank;
	
	
	public CustomObjectStudent(String name, String age, String rank) {
		super();
		this.name = name;
		this.age = age;
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "CustomObjectStudent [name=" + name + ", age=" + age + ", rank=" + rank + "]";
	}
	
	
}
