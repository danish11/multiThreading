package com.java.thread;

import java.util.stream.IntStream;

public class Synchronization {
	private int count =0;
public static void main(String[] args) {
	Synchronization sync = new Synchronization();
	sync.doWork();
}
private void doWork() {
	Thread t1 = new Thread(()->{
		IntStream.range(0,100).forEach(i->{
			count++;
		});
		/*for(int i=0 ; i< 100 ;i++){
			count++;
		}*/
	});
	Thread t2 = new Thread(() -> {
		IntStream.range(0,100).forEach(i->{
			count++;
		});
		/*for(int i=0 ; i< 100000 ;i++){
			count++;
		}*/
	});
	
	t1.start();
	t2.start();
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println(count);
}
}
