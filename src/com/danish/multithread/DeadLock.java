package com.danish.multithread;

public class DeadLock extends Thread{
	Pen p = new Pen();
	Paper p2 = new Paper();
	public static void main(String[] args) {
		
		DeadLock d  = new DeadLock();
		 Thread t1 = new Thread(d);
		 Thread t2 = new Thread(d);
		 t1.start();
		 t2.start();
		 
		
		
		
	}
	
  	public void run() {
  		synchronized(p){
			p.pen();
			synchronized (p2) {
				p2.paper();
			}
		}
  		
  		synchronized(p2){
			p.pen();
			synchronized (p) {
				p2.paper();
			}
		}
	}
	

}
class Pen{
	public void pen(){
		System.out.println("give pen");
	}
	
}

class Paper{
	public void paper(){
		System.out.println("give paper");
	}
	
}