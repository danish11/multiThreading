package com.danish.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreTest {
public static void main(String[] args) {
	//Connection.getInstance().connect();
	ExecutorService service =Executors.newCachedThreadPool();
	for (int i = 0; i < 100; i++) {
		service.submit(new Runnable(){
			@Override
			public void run() {
				Connection.getInstance().connect();
			}
			
		});
	}
	
	service.shutdown();
}
}
