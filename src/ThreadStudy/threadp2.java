package ThreadStudy;


public class threadp2 {
	public static ThreadLocal<Data> tl =new ThreadLocal<>();
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				//保证一个线程只能存一个Date
				Data data = Data.getInstence("cn", 18);
				tl.set(data);
				Data data2 = Data.getInstence("cx", 19);
				tl.set(data2);
				data2.age = 19;
				data2.name = "cx";
				tl.set(data2);
				
				A1 a1 = new A1();
				B1 b1 = new B1();
				a1.print();
				b1.print();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Data data = Data.getInstence("cn", 18);
				tl.set(data);
				
				A1 a1 = new A1();
				B1 b1 = new B1();
				a1.print();
				b1.print();
			}
		}).start();
		//主线程对象为空
		System.out.println(tl.get());
	}
}
class A1 {
	public void print() {
		Data data = threadp2.tl.get();
		System.out.println(Thread.currentThread().getName()+"-A1-"+data);
	}
}
class B1 {
	public void print() {
		Data data = threadp2.tl.get();
		System.out.println(Thread.currentThread().getName()+"-B1-"+data);
	}
}

class Data{
	String name;
	int age;
	private Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Data(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public static Data getInstence(String name,int age) {
		//获取当前线程的唯一指定对象
		Data data = threadp2.tl.get();
		if (data==null) {
			data = new Data(name, age);
		}
		return data;
	}
	@Override
	public String toString() {
		return "Data [name=" + name + ", age=" + age + "]";
	}
}