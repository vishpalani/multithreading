package com.redim.multithreading;

class EnumThread extends Thread {

	private static volatile boolean flag = true;

	public void stopThread() {
		flag = false;
	}

	public void run() {
		while (flag) {
			System.out.println("not alive");
		}
	}

}

public class EnumeratingThreads {

	public static void main(String[] args) {

		EnumThread enumThread = new EnumThread();

		Thread t1 = new Thread() {
			public void run() {

			}
		};

		Thread t2 = new Thread() {
			public void run() {

			}
		};

		t1.start();
		t2.start();
		enumThread.start();
		enumThread.stopThread();

		Thread thread[] = new Thread[Thread.activeCount()];
		int n = Thread.enumerate(thread);
		for (int i = 0; i < n; i++) {
			System.out.println("Thread " + i + " is " + thread[i].getName());
		}
	}
}
