package com.rafi.shallow.and.deep.cloning;

public class DeepStudent implements Cloneable{

	int id;
	String name;
	DeepAddress address;
	
	
	public DeepStudent(int id, String name, DeepAddress address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Object clone() throws CloneNotSupportedException {
		DeepStudent cloned=(DeepStudent) super.clone();
		cloned.setAddress((DeepAddress) cloned.getAddress().clone());
		return cloned;
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
	public DeepAddress getAddress() {
		return address;
	}
	public void setAddress(DeepAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
