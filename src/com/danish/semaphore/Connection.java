package com.danish.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {
private static Connection getInstance = new Connection();
private Semaphore sem = new Semaphore(10);
private int connections=0;
private Connection(){
	
}

public static Connection getInstance(){
	return getInstance;
}

public void connect(){
	try {
		sem.acquire();
		doconnect();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		sem.release();
	}
	
}
public void doconnect(){
	synchronized (this) {
		connections++;
		System.out.println(connections);
	}
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	synchronized (this) {
		connections--;
	}
}

}
