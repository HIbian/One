package com.test.java;
public class Test {
	public static void main(String[] args) {
		Person man = new Man();
		Person woman =new Woman();
		Jump(man);
		System.out.println("-----------------------------------------");
		Jump(woman);
	}
	public static void Jump(Person p) {
		p.eat();
		p.move();
		p.look();
		p.sleep();
		if (p instanceof Man) {
			Man man  = (Man)p;
			man.PlayGame();
		}else if (p instanceof Woman) {
			Woman woman = (Woman)p;
			woman.GoStreet();
		}
		
	}
}
