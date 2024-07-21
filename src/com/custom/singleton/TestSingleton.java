package com.custom.singleton;

public class TestSingleton {

	public static void main(String[] args) {
		LazyInnerClassSingleton lazyInner1=LazyInnerClassSingleton.getInstance();
		LazyInnerClassSingleton lazyInner2=LazyInnerClassSingleton.getInstance();
		
		System.err.println(lazyInner1 == lazyInner2);
		System.err.println(lazyInner1.equals(lazyInner2));
	}
}
