package com.object.stream;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6539905068957602592L;



	private String name;
	private transient int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
