package com.redim.deadlock;

class Pen {
}

class Paper {
}

public class Write {

	public static void main(String[] args) {
		Pen pen = new Pen();
		Paper paper = new Paper();

		Thread t1 = new Thread() {
			public void run() {
				synchronized (pen) {
					System.out.println("Thread1 is holding Pen");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					synchronized (paper) {
						System.out.println("Requesting for Paper");
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (paper) {
					System.out.println("Thread2 is holding Paper");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// do something
					}
					synchronized (pen) {
						System.out.println("requesting for Pen");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}
}
