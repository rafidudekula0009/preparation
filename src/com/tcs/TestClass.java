package com.tcs;

public class TestClass {

	public static void main(String[] args) {

		Test<Integer, Integer, Integer> sum = (a, b) -> a + b;
		System.out.println(sum.execute(2, 3));

	}

}