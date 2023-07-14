package com.redim.multithreading;

interface abstractEx {
	public void getNames();
}

abstract class example {
	abstract void print();
}

class RunnableEx extends example implements Runnable,abstractEx {

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Runnable Interface");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void getNames() {
		System.out.println("interface implementation");
	}

	@Override
	void print() {
		System.out.println("class implementation");
	}
}

public class RunnableExample {

	public static void main(String[] args) {
		RunnableEx ex=new RunnableEx();
		Thread thread=new Thread(ex);
		thread.start();
		ex.getNames();
		ex.print();
	}

}
