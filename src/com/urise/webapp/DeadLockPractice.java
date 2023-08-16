package com.urise.webapp;

public class DeadLockPractice {
    public static final String Lock1 = "Lock1";
    public static final String Lock2 = "Lock2";

    public static void main(String[] args) {
        deadLock(Lock1, Lock2);
        deadLock(Lock2, Lock1);
    }

    private static void deadLock(Object lock1, Object lock2) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Holding " + lock1);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Waiting for " + lock2);

                synchronized (lock2) {
                    System.out.println("Holding lock " + lock1 + " " + lock2);
                }
            }
        }).start();
    }
}
