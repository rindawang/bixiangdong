package com.rinda.thread;

public class SingletonAnquan {

}

class Single1 {
	// 饿汉模式
	private Single1 s1 = new Single1();

	private Single1() {

	}

	public Single1 getInstance() {
		return s1;
	}
}

class Single2 {
	// 懒汉模式
	private Single2 s2 = null;

	private Single2() {

	}

	// 方式一： 给方法加同步
	/*
	 * public synchronized Single2 getInstance(){ if(s2 == null){ s2 = new
	 * Single2(); } return s2; }
	 */
	// 方式二： 加同步block,但是会造成效率底，因为每次获取都需要整段同步。
	/*
	 * public Single2 getInstance() { synchronized (Single2.class) { if (s2 ==
	 * null) { s2 = new Single2(); } return s2; } }
	 */
	// 方式三： 加双重判断
	public Single2 getInstance() {
		if (s2 == null) {
			synchronized (Single2.class) {
				if (s2 == null) {
					s2 = new Single2();
				}
			}
		}
		return s2;
	}
}