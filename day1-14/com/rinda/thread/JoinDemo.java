package com.rinda.thread;

public class JoinDemo {

	public static void main(String[] args) throws Exception {

		ThreadGroup tg = new ThreadGroup("My Group");
		JoinD jd = new JoinD();
		Thread t1 = new Thread(tg, jd);
		Thread t2 = new Thread(tg, jd);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();

		//t1.join();

		for (int i = 0; i < 50; i++) {
			//System.out.println(Thread.currentThread() + "......" + i);
		}
	}
}

class JoinD implements Runnable {

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread() + "......" + i);
			Thread.currentThread().yield();
		}

	}

}
