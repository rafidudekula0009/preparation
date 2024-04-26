package com.interview.questions;

class A{
	
}
class B extends A{
	B(){
		
	}
	void show(){
	System.out.println("B Show");	
	}
}
class C extends B{
	C(){
		
	}
//	A(){
//		
//	}
}

public class Inheritance {

	public static void main(String[] args) {
		A a = new B();
		((B) a).show();
	}
}
