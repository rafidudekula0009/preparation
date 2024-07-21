package com.custom.singleton;

public class LazySingleton {

	private LazySingleton() {}
	
	private static LazySingleton instance;
	
	public static LazySingleton getInstance() {
		if(instance==null) {
			return instance=new LazySingleton();
		}else {
			return instance;
		}
	}
}
