package com.multi.threading;


class ThreadByImplementingRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread created with runnable interface is executed!! ");
	}

}

class ThreadByExtendingThread extends Thread{
	public void run() {
		System.out.println("Thread created by extending Thread class executed!!");
	}
}


public class ThreadCreation {

	public static void main(String[] args) {

		//1
		// Using Runnable
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("My Thread run method inside runnable!! by thread => "+Thread.currentThread().getName());
			}
		};

		Thread thread1 = new Thread(runnable);
		System.out.print("calling run method of runnable using thread1 => ");thread1.run();
		System.out.println("Name of thread1 => "+thread1.getName());

		System.out.println("----------------End of Thread1---------------------------\n");

		//2
		Thread thread2 = new Thread("Thread created with constructor Thread(\"String\") executed!!");
		thread2.run();//No run method implemented by us. so no o/p
		System.out.println("Name of thread2 => "+thread2.getName());
		System.out.println("----------------End of Thread2---------------------------\n");

		//3
		Thread thread3 = new Thread(runnable, "Thread created by using constructor with runnable and string parameters");
		System.out.print("calling run method of runnable using thread3 => ");thread3.run();//As we implemented run inside runnable, it is executed and o/p is printed
		System.out.println("Name of thread3 => "+thread3.getName());
		System.out.println("----------------End of Thread3---------------------------\n");

		//4
		Thread thread4 = new Thread(new ThreadByImplementingRunnable());
		System.out.print("calling run method of runnable using thread4 => "); thread4.run();
		System.out.println("Name of thread4 => "+thread4.getName());
		System.out.println("----------------End of Thread4---------------------------\n");

		//5
		Thread thread5 = new ThreadByExtendingThread();
		System.out.print("calling run method of Thread using thread5 => "); thread5.run();
		System.out.println("Name of thread5 => "+thread5.getName());
		System.out.println("----------------End of Thread5---------------------------\n");
	}



}
