package com.rinda.thread;

public class SaleTicketSyncMothod {
	public static void main(String[] args) {

		TicketSync t1 = new TicketSync(100, "火車票");

		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		thread1.start();
		thread2.start();
	}

}

class TicketSync implements Runnable {
	private static int num;
	private static String name;

	Object obj = new Object();

	public TicketSync(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public void run() {
		while (true) {
			if (Thread.currentThread().getName().equals("Thread-0")) {
				synchronized (TicketSync.class) {
					if (num > 0) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
						}
						System.out.println(Thread.currentThread().getName() + "Block  sales:" + name + num--);
					}
				}
			} else {
				sale();
			}

		}
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		TicketSync.num = num;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		TicketSync.name = name;
	}

	public static synchronized void sale() {
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + "Method sales:" + name + num--);
		}
	}
}
