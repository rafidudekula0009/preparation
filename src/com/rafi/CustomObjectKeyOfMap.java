package com.rafi;

import java.util.HashMap;
import java.util.Map;

public class CustomObjectKeyOfMap {

	public static void main(String[] args) {
		Map<CustomObjectStudent, String> map=new HashMap<CustomObjectStudent, String>();
		
		CustomObjectStudent s1=new CustomObjectStudent("rafi", "25", "26");
		CustomObjectStudent s2=new CustomObjectStudent("ranju", "31", "1");
		CustomObjectStudent s3=new CustomObjectStudent("sandhya", "33", "1.1");
		
		map.put(s1,"rafi");
		map.put(s2,"ranjan");
		map.put(s3,"sandhya aluru");
		map.put(s3,"chintu");
		System.out.println("Hash of rafi => "+s1.hashCode());
		s1.setName("rafi2.0");
		map.put(s1,"rafi2.0");
		
		
		map.keySet().stream().forEach(key->System.out.println(key+ " => " +key.hashCode()));
		
		System.out.println(map);
	}
	
}
