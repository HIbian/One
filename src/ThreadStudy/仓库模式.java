package ThreadStudy;

public class 仓库模式 {
	public static void main(String[] args) {
		store s = new store();
		produ p = new produ(s);
		produ p1= new produ(s);
		cus c = new cus(s);
		cus c1 = new cus(s);
		p.start();
		p1.start();
		c.start();
		c1.start();
		
	}
}
class store{
	private final int max = 2000;//最大数量
	private  int sum = 0;//产品数量
	
	//入库
	public void push() {
		synchronized (this) {
			while (sum >= max) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			sum++;
			System.out.println(Thread.currentThread().getName()+"入库" + sum);
			this.notifyAll();
		}
	}
	//出库
	public void pop() {
		synchronized (this) {
			while (sum <= 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				};
			}
			sum--;
			System.out.println(Thread.currentThread().getName()+"出库" + sum);
			this.notifyAll();
		}
	}
}
class produ extends Thread{
	private store s;
	
	public produ() {
	}

	public produ(store s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		while (true) {
			s.push();
		}
	}

	
}
class cus extends Thread{
	private store s;
	
	public cus() {
	}

	public cus(store s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		while (true) {
			s.pop();
		}
	}
}
