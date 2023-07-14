package com.redim.multithreading;

public class AnonymousClass {

	public static void main(String[] args) {

		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("using thread");
			}
		};
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("using runnable");
			}
		});
		
		//lambda
		Thread t1=new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("lamdba expression using thread "+i);
			}
		});
		
		
		Runnable runnable = () -> {
			for(int i=0;i<5;i++) {
				System.out.println("lambda expression runnable "+i);
			}
		};
		Thread t2 = new Thread(runnable);
		
		thread1.start();
		t1.start();
		thread2.start();
		t2.start();
		
		
	}

}
