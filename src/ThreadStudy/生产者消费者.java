package ThreadStudy;


public class 生产者消费者 {
	public static void main(String[] args) {
		Phone phone = new Phone();
		Producer p = new Producer(phone);
		Producer p2 = new Producer(phone);
		Cusumor c = new Cusumor(phone);
		Cusumor c2 = new Cusumor(phone);
		p.start();
		c.start();
		p2.start();
		c2.start();
	}
	
}
//生产者
class Producer extends Thread{
	private Phone phone;
	private static boolean bool;//判断生产机型，多个对象需要共有
	
	public Producer() {
	}

	public Producer(Phone phone) {
		this.phone = phone;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (phone) {
				//如果有库存,循环判断
				while (phone.isStore()) {
					try {
						phone.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (bool) {
					phone.setBrand("华为");
					phone.setPrice(3999);
				} else {
					phone.setBrand("魅族");
					phone.setPrice(999);
				}
				bool = !bool;
				phone.setStore(true);
				//唤醒线程
				phone.notifyAll();
			}
		}
	}
	
}
//消费者
class Cusumor extends Thread{
	private Phone phone;
	
	public Cusumor() {
	}

	public Cusumor(Phone phone) {
		this.phone = phone;
	}
	@Override
	public void run() {
		
		while (true) {
			
			synchronized (phone) {
				//如果没有库存
				while (!phone.isStore()) {
					try {
						phone.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(phone.toString());
				phone.setStore(false);
				//唤醒线程
				phone.notifyAll();
			}
		}
	}
	
}
//实体类
class Phone{
	private String brand;
	private int price;
	private boolean store = false;
	
	public Phone() {
	}

	public boolean isStore() {
		return store;
	}

	public void setStore(boolean store) {
		this.store = store;
	}

	public Phone(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", price=" + price + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}