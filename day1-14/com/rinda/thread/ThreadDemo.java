package com.rinda.thread;

public class ThreadDemo {
	public static void main(String[] args) {
		Demo d1 = new Demo("d1");
		Demo d2 = new Demo("d2");
		Thread s1 = new Thread(d1);
		Thread s2 = new Thread(d2);

		s1.start();
		s2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Thread:" + Thread.currentThread().getName());
		}

	}

}

class Demo implements Runnable {
	private String name;

	Demo(String name) {
		this.name = name;
	}

	public void show() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "....i=" + i + "Thread:" + Thread.currentThread().getName());
		}
	}

	public void run() {
		show();
	}

}
