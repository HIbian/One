package com.test.java;

public class Woman extends Person{

	@Override
	public void eat() {
		System.out.println("细嚼慢咽");
	}

	@Override
	public void move() {
		System.out.println("走");
	}
	public void sleep() {
		System.out.println("好好碎觉，保养皮肤");
	}
	public void GoStreet() {
		System.out.println("逛街");
	}
	
}
