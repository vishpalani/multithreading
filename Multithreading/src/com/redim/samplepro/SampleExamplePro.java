package com.redim.samplepro;

class Notepad {
	public void writeNotes() {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("used to take notes");
		}
	}
}

class Paint{
	public void draw() {
		for(int i=0;i<5;i++) {
			System.out.println("used to draw");
		}
	}
}

public class SampleExamplePro {
	public static void main(String[] args) {
		Notepad notepad=new Notepad();
		Paint paint=new Paint();
		
		notepad.writeNotes();
		paint.draw();
	}
}
