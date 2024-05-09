package com.rafi.shallow.and.deep.cloning;

public class ShallowCloningExample{

	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowStudent student = new ShallowStudent(1001, "rafi", new ShallowAddress("21", "twopipeline", 518401));
		
		System.out.println("Student actual object => "+student);
		
		ShallowStudent student1 = (ShallowStudent) student.clone();
		
		System.out.println("Student cloned object => "+student1);
		
		student1.getName();
		student1.getAddress().setHouseNo("9"); // In shallow cloning a userdefined types reference will be shared rather
		// it's object. When we get that object and set then the
		// actual/original/parent object will be modified. whereas in deep
		// cloning we create clone of the child as well and then send it back
		// instead of original reference. You can find it in the DeepStudent
		// class
		
		System.out.println("after updating the clone object is => "+student1); //Student [id=1001, name=rafi, address=Address [houseNo=9, streetName=twopipeline, pincode=518401]]
		System.out.println("original object is => "+student); //Student [id=1001, name=rafi, address=Address [houseNo=9, streetName=twopipeline, pincode=518401]]
	}
}
