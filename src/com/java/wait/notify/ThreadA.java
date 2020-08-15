package com.java.wait.notify;

public class ThreadA {
public static void main(String[] args) {
	ThreadB b= new ThreadB(); 
	b.start();
	synchronized (b) {
		try {
			System.out.println(Thread.currentThread().getName());
			b.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.total);
		
	}
}
}
