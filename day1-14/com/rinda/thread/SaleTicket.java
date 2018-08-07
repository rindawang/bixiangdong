package com.rinda.thread;

public class SaleTicket {
	public static void main(String[] args) {

		Ticket t1 = new Ticket(100, "火車票");
		// Ticket t2 = new Ticket(50, "飛機票");
		/*
		 * t1.start(); t2.start(); t3.start(); t4.start();
		 */

		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		Thread thread3 = new Thread(t1);
		Thread thread4 = new Thread(t1);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

class Ticket implements Runnable {
	private int num;
	private String name;

	Object obj = new Object();

	public Ticket(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public void run() {
		while (true) {
			synchronized (obj) {
				if (num > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					System.out.println(Thread.currentThread().getName() + " sales:" + name + num--);
					
				}else{
					break;
				}
			}
		}
	}
}
