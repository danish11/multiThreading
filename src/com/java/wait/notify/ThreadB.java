package com.java.wait.notify;

public class ThreadB extends Thread{

	int total =0;
	public void run()
	{
		synchronized (this) {
			System.out.println("in TheadB" +Thread.currentThread().getName());
			for(int i=0;i<10;i++)
				total = total+i;
			notify();
		}
		
		
	}
}
