package com.redim.datainsyn;

public class DataInconsistencySyn {
    private static int count = 0;

    public static synchronized void incrementCount() {
        count++;
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//            		count++;
                incrementCount();
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
//            	count++;
                incrementCount();
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + count);
    }
}
