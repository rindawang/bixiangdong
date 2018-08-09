package com.rinda.thread;

public class WaitNotify {
	public static void main(String[] args) throws InterruptedException {
		Person p = new Person();
		Input input = new Input(p);
		Output output = new Output(p);
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);

		t2.start();
		t1.start();
	}
}

class Person {
	private String name;
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name, String sex) {
		if (flag) {
			try {
				// System.out.println("set value else block");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		this.flag = true;
		notify();

	}

	public synchronized void out() {
		if (!flag) {
			try {
				// System.out.println("out else block");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("----------------------------------" + name + ": " + sex);
		flag = false;
		notify();
	}
}

class Input implements Runnable {
	private Person p;

	public Input(Person p) {
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			if (i == 0) {
				p.set("Mike", "Male");
			} else {
				p.set("Lily", "Female");
			}
			i = ++i % 2;
		}
	}
}

class Output implements Runnable {
	private Person p;

	public Output(Person p) {
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			p.out();
		}
	}
}