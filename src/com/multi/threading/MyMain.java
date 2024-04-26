package com.multi.threading;

class TotalEarningsThread extends Thread{

	int total=0;
	
	@Override
	public void run() {
		synchronized (this) {
		for(int i=1;i<=10;i++) {
			System.out.println("totalearningsthread => "+i);
			total=total+100;
		}
//		synchronized (this) { // same o/p
			this.notify();	
		}
		
	}
}

public class MyMain {	
	
	public static void main(String[] args) throws InterruptedException {
		TotalEarningsThread tet=new TotalEarningsThread();
		tet.start();
		System.out.println("Total earnings without calling wait() = "+tet.total);
		synchronized (tet) {
			tet.wait();
		}
		//or
//		tet.join();
		System.out.println("Total earnings after calling wait() = "+tet.total);
	}
}
