package com.custom.arraylist;

public class CustomListTest {
	public static void main(String[] args) {
	
		CustomList<Integer> list=new CustomList<Integer>(2); //we are setting max capacity as 2
		
		list.add(1);
		list.add(2);
//		list.add(3); //If we this element then size is more than 2. It will throw exception
//		System.out.println(list.size());
		System.out.println(list);
	}
}