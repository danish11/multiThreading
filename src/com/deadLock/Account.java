package com.deadLock;

public class Account {

	private int balance=1000;
	
	public void deposit(int sum){
		balance +=sum;
	}
	public void withdrew(int sum){
		balance -=sum;
	}
	
	public int getBalance(){
		return balance;
	}
	public static void transfer(Account acc1, Account ac2, int sum){
		acc1.withdrew(sum);
		ac2.deposit(sum);
	}
}
