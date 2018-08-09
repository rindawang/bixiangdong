package com.rinda.thread;

public class StopThreadDemo {
	public static void main(String[] args) {
		StopThread st = new StopThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t2.setDaemon(true);
		t1.start();
		t2.start();

		int number = 0;
		while (true) {
			System.out.println(number);
			if (++number == 9999) {
				//st.setFlag(false);
				t1.interrupt();
		
				System.out.println("over");
				break;
			}
		}

	}
}

class StopThread implements Runnable {
	private boolean flag = true;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
	
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e+ "...........");
				flag= false;
			}
			System.out.println(Thread.currentThread().getName() + "Still Running......");
		}
	}

}
