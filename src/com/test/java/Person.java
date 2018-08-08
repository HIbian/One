package com.test.java;

public abstract class Person implements IEat{

	abstract public void eat();
	abstract public void move();
	
	public void look() {
		System.out.println("看看天");
	}
	
}