package com.java8;

import com.custom.functional.interfaces.CustomSayHelloOperation;

public class CustomFunctionalInterfaceDemo {

	public static void main(String[] args) {
		CustomSayHelloOperation<String> sayHello = msg -> System.out.print("hello "+msg);
		
		sayHello.sayHello("Rafi");
	}
}
