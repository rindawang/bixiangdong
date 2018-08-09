package com.rinda.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Resource r = new Resource();
		Producer p = new Producer(r);
		Consumer c = new Consumer(r);
		Thread t0 = new Thread(p);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

}

class Consumer implements Runnable {
	Resource r;

	public Consumer(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			r.out();
		}
	}
}

class Producer implements Runnable {
	Resource r;

	public Producer(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			r.set("烤鸭");
		}
	}
}

class Resource {

	private String name;
	private int count = 1;
	private boolean exist = false;
	final private Lock lock = new ReentrantLock();
	final private Condition setCon = lock.newCondition();
	final private Condition outCon = lock.newCondition();

	public void set(String name) {
		try {
			lock.lock();
			while (exist) {
				try {
					setCon.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.name = name + count++;
			System.out.println(Thread.currentThread().getName() + "...Producer..." + this.name);
			exist = true;
			outCon.signal();
		} finally {
			lock.unlock();
		}
	}

	public synchronized void out() {
		try {
			lock.lock();
			while (!exist) {
				try {
					outCon.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "......Consumer......" + this.name);
			exist = false;
			setCon.signal();
		} finally {
			lock.unlock();
		}
	}
}