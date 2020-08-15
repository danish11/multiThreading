package com.danish.interuptiingthreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterupptingThreads {
public static void main(String[] args) {

	ExecutorService exec = Executors.newCachedThreadPool();
	exec.submit(new Callable<Integer>() {
		@Override
		public Integer call() throws Exception {
			for (int i = 0; i < 1E6; i++) {
				
			}
			return null;
		}
	});
	
}
}
