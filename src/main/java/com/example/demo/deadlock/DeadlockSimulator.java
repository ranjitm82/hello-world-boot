package com.example.demo.deadlock;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DeadlockSimulator {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    @PostConstruct
    public void createDeadlock() {
    	
        Thread t1 = new Thread(() -> {
        	
            synchronized (lock1) {
            	
                System.out.println("Thread-1 acquired lock1");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                synchronized (lock2) {
                    System.out.println("Thread-1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread-2 acquired lock2");
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                synchronized (lock1) {
                    System.out.println("Thread-2 acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
