package com.redim.multithreading;

interface abstractExple {
	public void getNames();
}

class MyThread extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Java-multithread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class ThreadExtends {
	public static void main(String[] args) {
		MyThread myThread=new MyThread();
		myThread.start();
	}
}
