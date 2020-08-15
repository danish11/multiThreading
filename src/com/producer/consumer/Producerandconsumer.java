package com.producer.consumer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producerandconsumer {

	private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);
	public static void main(String[] args) throws InterruptedException {
		Map s = new HashMap();
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}	
	
	public static void producer() throws InterruptedException{
		Random r = new Random();
		while(true){
			bq.put(r.nextInt(100));
		}
	}
	public static void consumer() throws InterruptedException{
		Random r = new Random();
		while(true){
			Thread.sleep(100);
			if(r.nextInt(10) == 0){
				Integer value =	bq.take();
					System.out.println("taken value: "+value+";"
							+ " queue size: " + bq.size());
				
			}
		}
	}
}
