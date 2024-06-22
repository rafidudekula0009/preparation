package com.tcs;

@FunctionalInterface
public interface Test<T, U, R> {
        
  public R execute(T t, U u);
  
}


//Implement above functional interface using lambda expression to calculate sum of two numbers



