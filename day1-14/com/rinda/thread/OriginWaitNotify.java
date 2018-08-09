package com.rinda.thread;

public class OriginWaitNotify {

	public static void main(String[] args) throws InterruptedException {
		OPerson p = new OPerson();
		OInput input = new OInput(p);
		OOutput output = new OOutput(p);
		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);

		t2.start();
		t1.start();
	}
}

class OPerson {
	private String name;
	private String sex;
	private boolean flag=false;

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

class OInput implements Runnable {
	private OPerson p;

	public OInput(OPerson p) {
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
						p.setFlag(true);
						p.notify();
					} else {
						p.setName("Lily");
						p.setSex("Female");
						p.setFlag(true);
						p.notify();
					}
					
					i = ++i % 2;
				} else {
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class OOutput implements Runnable {
	private OPerson p;

	public OOutput(OPerson p) {
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
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}