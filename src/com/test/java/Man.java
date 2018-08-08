package com.test.java;


public class Man extends Person{
	public void eat() {
		System.out.println("大口吃肉");
	}
	public void move() {
		System.out.println("跑");
	}
	@Override
	public void sleep() {
		System.out.println("随你麻痹起来嗨");
	}
	public void PlayGame() {
		System.out.println("打游戏");
	}
}
