package com.custom.singleton;

public class LazyInnerClassSingleton {

	private LazyInnerClassSingleton() {
	}

	private static class SingletonHelper {
		private static final LazyInnerClassSingleton instance = new LazyInnerClassSingleton();
	}

	// there won't be issue even in multi thread env as the instance of the outer
	// class won't be created until getInstance method is invoked
	public static LazyInnerClassSingleton getInstance() {
		return SingletonHelper.instance;
	}

}