package com.example.interthreadcommunication;

class Mythread extends Thread {
	int total=0;
	
	public void run() {
		synchronized (this) {
			System.out.println("starting thread");
				total=total+10;
			this.notify();
		}
	}
}

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		Mythread mythread=new Mythread();
		mythread.start();
		
		synchronized(mythread) {
			mythread.wait();   
			Thread.sleep(2000);
			System.out.println("total= "+mythread.total);
			
		}
	}

}
