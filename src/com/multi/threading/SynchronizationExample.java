package com.multi.threading;

class BookTheatreSeats{
	int total_seats=10;
	void bookSeats(int noOfSeats) {
		System.out.println(Thread.currentThread().getName()+", NoOfSeats = "+noOfSeats);
		if(total_seats>=noOfSeats) {
			total_seats=total_seats-noOfSeats;
			System.out.println("Seats left = "+Thread.currentThread().getName()+", "+total_seats);
		}else {
			System.out.println("Seats cannot be booked. Total seats left = "+Thread.currentThread().getName()+", "+total_seats);
		}
	}
}

public class SynchronizationExample extends Thread{

	static BookTheatreSeats bts;
	int noOfSeatsToBook;
	
	public void run() {
		bts.bookSeats(noOfSeatsToBook);
	}
	
	public static void main(String[] args) {
		bts=new BookTheatreSeats();
		
		SynchronizationExample person1=new SynchronizationExample();
		person1.noOfSeatsToBook=7;
		person1.start();
		
		SynchronizationExample person2=new SynchronizationExample();
		person2.noOfSeatsToBook=6;
		person2.start();
		
//		SynchronizationExample person3=new SynchronizationExample();
//		person3.noOfSeatsToBook=4;
//		person3.start();
		
		
	}
	
}
