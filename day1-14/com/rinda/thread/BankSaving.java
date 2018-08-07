package com.rinda.thread;

public class BankSaving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c1 = new Customer("Rinda");
		Customer c2 = new Customer("Stefan");
		Thread t11 = new Thread(c1);
		Thread t12 = new Thread(c1);
		Thread t13 = new Thread(c1);
		t11.start();
		t12.start();
		t13.start();

		/*
		 * Thread t21 = new Thread(c2); Thread t22 = new Thread(c2); Thread t23
		 * = new Thread(c2); t21.start(); t22.start(); t23.start();
		 */

	}

}

class Account {

	private int sum;
	private Object obj = new Object();

	public synchronized void add(int num) {
		//synchronized (obj) {
			sum += num;
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
			System.out.println(Thread.currentThread().getName() + " Current sum is: " + this.getSum());
		//}
	}

	public int getSum() {
		return sum;
	}
}

class Customer implements Runnable {
	private Account account = new Account();
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		// synchronized (obj) {
		for (int i = 0; i < 10; i++) {
			account.add(1);

		}
		// }

	}

}
