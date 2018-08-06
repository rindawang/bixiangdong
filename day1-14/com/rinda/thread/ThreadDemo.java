package com.rinda.thread;

public class ThreadDemo {
	public static void main(String[] args){
		Demo d1 = new Demo("d1");
		Demo d2 = new Demo("d2");
	    d1.start();
	    d2.start();
	    System.out.println(4/0);
		for(int i = 0; i < 10; i ++){
			System.out.println("Thread:"+ Thread.currentThread().getName());
		}

	}

}

class Demo extends Thread{
	private String name;
	Demo(String name){
		super(name);
		this.name = name;
	}
	
	public void run(){
		for(int i = 0; i < 10; i ++){
			System.out.println(name + "....i=" + i + "Thread:"+ Thread.currentThread().getName());
		}
	}

}
