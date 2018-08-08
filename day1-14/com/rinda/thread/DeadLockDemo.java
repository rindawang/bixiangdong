package com.rinda.thread;

public class DeadLockDemo {

	public static void main(String[] args) {
		Run1 r1 = new Run1();
		Run2 r2 = new Run2();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}

class Locks {
	public static final Locks l1 = new Locks();
	public static final Locks l2 = new Locks();
}

class Run2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (Locks.l2) {
				System.out.println("run2 get lock l2");
				synchronized (Locks.l1) {
					System.out.println("run2 get lock l1");
				}

			}
		}
	}

}

class Run1 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (Locks.l1) {
				System.out.println("run1 get lock l1");
				synchronized (Locks.l2) {
					System.out.println("run1 get lock l2");
				}

			}
		}
	}

}