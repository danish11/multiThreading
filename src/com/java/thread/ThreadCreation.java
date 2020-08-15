package com.java.thread;

public class ThreadCreation {
public static void main(String[] args) {
	Thread t = new Thread(()->{
	System.out.print("Hi");
	});
	t.start();
}
}
