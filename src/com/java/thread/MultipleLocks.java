package com.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MultipleLocks {

	private Random  random = new Random();
	
	Object obj1 = new Object();
	Object obj2 = new Object();
	
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	
	public  void stageOne(){
		synchronized (obj1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	public  void stageTwo(){
		synchronized (obj2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
	}
		public  void process(){
			IntStream.range(0, 1000).forEach(i->{
				stageOne();
				stageTwo();
			});
			/*for (int i = 0; i < 1000; i++) {
				stageOne();
				stageTwo();
			}*/
		}
		public static void main(String[] s) throws InterruptedException{
			MultipleLocks multipleLocks = new MultipleLocks();
			System.out.println("starting........");
			long startTime = System.currentTimeMillis();
			Thread t1 = new Thread(()->{
				multipleLocks.process();
			});
			
			Thread t2 = new Thread(()->{
				multipleLocks.process();
			});
			t1.start();
			t2.start();
			t1.join();
			t2.join();
			long endtime = System.currentTimeMillis();
			System.out.println("time taken:" +(endtime - startTime));
			System.out.println("l1 size: " + multipleLocks.list1.size()
					+ " l2 size: " + multipleLocks.list2.size());
		}
}
