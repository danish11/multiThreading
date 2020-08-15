package com.reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner {
	
	private int counter =0;
	private Lock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	
	private void increment(){
		for (int i = 0; i < 1; i++) {
			counter++;
		}
	}

	public void firstRunner() throws InterruptedException{
		lock.lock();
		System.out.println("waiting");
		con.await();
		System.out.println("wooken up");
		try{
			System.out.println("wooken up1"+ counter);
			increment();
			System.out.println("wooken up2"+ counter);
		}
		finally{
		lock.unlock();
		}
	}
	
	public void secondRunner() throws InterruptedException{
		Thread.sleep(1000);
		
		lock.lock();
		System.out.println("press the return key");
		new Scanner(System.in).nextLine();
		System.out.println("Got the key");
		con.signal();
		System.out.println("Got the key1"+ counter);
		try{
			increment();
			System.out.println("Got the key2"+ counter);
		}
		finally{
		lock.unlock();
		}
	}
	
	public void finished(){
		System.out.println(counter);
	}
}
