package ThreadStudy;

import java.util.concurrent.ConcurrentHashMap;

public class threadpractice{
	//键值对，分别存储线程对象和线程对象里的值，可用于外部访问
	public static ConcurrentHashMap<Thread, Integer> chm = new ConcurrentHashMap<>();
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 99;
				chm.put(Thread.currentThread(), i);
				A a = new A();
				B b = new B();
				a.print();
				b.print();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 33;
				chm.put(Thread.currentThread(), i);
				A a = new A();
				B b = new B();
				a.print();
				b.print();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 66;
				chm.put(Thread.currentThread(), i);
				A a = new A();
				B b = new B();
				a.print();
				b.print();
			}
		}).start();

	}
}
class A{
	public void print() {
		Integer value = threadpractice.chm.get(Thread.currentThread());
		System.out.println(Thread.currentThread().getName()+"-A-"+value);
	}
}
class B{
	public void print() {
		Integer value = threadpractice.chm.get(Thread.currentThread());
		System.out.println(Thread.currentThread().getName()+"-B-"+value);
	}
}