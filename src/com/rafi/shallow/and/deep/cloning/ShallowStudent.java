package com.rafi.shallow.and.deep.cloning;

public class ShallowStudent implements Cloneable{

	int id;
	String name;
	ShallowAddress address;
	
	
	public ShallowStudent(int id, String name, ShallowAddress address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ShallowAddress getAddress() {
		return address;
	}
	public void setAddress(ShallowAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
