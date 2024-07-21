package com.custom.singleton;

public class DoubleCheckingLazySingleton {

	private DoubleCheckingLazySingleton() {
	}

	private static DoubleCheckingLazySingleton instance;

	// Used synchronized keyword at condition/block level To avoid 2 threads invoking this method at same time and try to create
	// instance at same time and cause issues which would be better approach than synchronized method.
	public static synchronized DoubleCheckingLazySingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckingLazySingleton.class) {
				if(instance==null) {
					instance = new DoubleCheckingLazySingleton();
				}
			}
		}
		return instance;
	}
}
