package com.redim.samplepro;

class Notepads extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("used to take notes");
		}
	}
}

class Paints implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("used to draw");
		}
	}
}

public class ThreadAdv {
	public static void main(String[] args) {
		Notepads notepads=new Notepads();
		Paints paints=new Paints();
		
		notepads.start();
		Thread thread=new Thread(paints);
		thread.start();
	    	
	}
}
