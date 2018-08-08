package com.rinda.thread;

public class WaitNotify {
	public static void main(String[] args) throws InterruptedException {
		Person p = new Person();
		Input input = new Input(p);
		Output output = new Output(p);
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);

		t2.start();
		Thread.currentThread().sleep(10000);
		t1.start();
	}
}

class Person {
	private String name;
	private String sex;
	private boolean flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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
			synchronized (p) {
				if (!p.isFlag()) {
					if (i == 0) {
						p.setName("Mike");
						p.setSex("Male");
					} else {
						p.setName("Lily");
						p.setSex("Female");
					}
					p.setFlag(true);
					i = ++i % 2;
					p.notify();

				} else {
					System.out.println("input else wait");
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	
				}

			}
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
			synchronized (p) {
				if (p.isFlag()) {
					System.out.println(p.getName() + ": " + p.getSex());
					p.setFlag(false);
					p.notify();

				} else {
					System.out.println("output else wait");
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}