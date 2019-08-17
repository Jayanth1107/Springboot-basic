package com.jay;

public class Person2 {
	private String name;
	private int age;
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person2() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s]", name, age);
	}

}
