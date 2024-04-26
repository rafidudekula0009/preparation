package com.custom.functional.interfaces;

@FunctionalInterface
public interface CustomSayHelloOperation<T> {

	abstract void sayHello(T msg);
}
