package com.rafi;

import java.util.LinkedList;

public class Dummy {

	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		
		cars.add("Nexon");
		cars.add("Swift");
		cars.add("Safari");
		cars.add("Harrier");
		
		System.out.println(cars);
		
		cars.add(2, "dummy");
		System.out.println(cars);
		
		LinkedList<String> bikes = new LinkedList<String>();
		
		bikes.add("unicorn");
		bikes.add("activa");
		bikes.add("pulsar");
		
		cars.addAll(bikes);
		
		System.out.println(cars);
		
		cars.addAll(0, bikes);
		System.out.println(cars);
		System.out.println(cars.contains("Nexon"));
	}
}
