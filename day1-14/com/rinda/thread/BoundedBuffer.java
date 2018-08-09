package com.rinda.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Buffer {
	Lock lock = new ReentrantLock();
	final Condition notEmpty = lock.newCondition();
	final Condition notFull = lock.newCondition();
	int count, putPoint, takePoint;
	String[] s = new String[100];

	public void put(String input) {
		try {
			lock.lock();
			while (count > s.length) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			s[putPoint] = input;
			if (putPoint < s.length - 1)
				putPoint++;
			else
				putPoint = 0;
			count++;
			notEmpty.signal();

		} finally {
			lock.unlock();
		}

	}

	public String take() {
		try {
			lock.lock();
			while (count <= 0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String result = s[takePoint];
			if (takePoint < s.length - 1)
				takePoint++;
			else
				takePoint = 0;
			count--;
			notFull.signal();
			return result;
		} finally {
			lock.unlock();
		}
	}
}
