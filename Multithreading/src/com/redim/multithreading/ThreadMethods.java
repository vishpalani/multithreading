package com.redim.multithreading;

class Book extends Thread{
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Java");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PrintNumber implements Runnable {
	public void run() {
		int i = 1;
		while (i <= 5) {
			System.out.println("i = " + i);
			try {
			Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}

public class ThreadMethods {

	public static void main(String[] args) {
		Book book = new Book();
		PrintNumber numbers = new PrintNumber();

		book.start();
		System.out.println("book is alive "+book.isAlive());
		try {
		book.join();
		}catch(InterruptedException e) {}
		
		Thread number= new Thread(numbers);
		number.start();
		try {
			number.join();
			}catch(InterruptedException e) {}
		
		//priority
		System.out.println("book priority== "+book.getPriority());
		number.setPriority(Thread.MAX_PRIORITY);
		System.out.println("number priority= "+number.getPriority());
		
		//name
		System.out.println("book thread name= "+book.getName());
		number.setName("NumberThread");
		System.out.println("number thread name= "+number.getName());
		
		//alive
		System.out.println("book is alive = "+book.isAlive()); 
		
		//currentThread
		System.out.println("current Execution Thread= "+Thread.currentThread());
	}

}
