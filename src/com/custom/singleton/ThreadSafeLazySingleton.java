package com.custom.singleton;

public class ThreadSafeLazySingleton {

	private ThreadSafeLazySingleton() {
	}

	private static ThreadSafeLazySingleton instance;

	// Used synchronized keyword at method level To avoid 2 threads invoking this method at same time and try to create
	// instance at same time and cause issues.
	public static synchronized ThreadSafeLazySingleton getInstance() {
		if (instance == null) {
			return instance = new ThreadSafeLazySingleton();
		} else {
			return instance;
		}
	}
}
