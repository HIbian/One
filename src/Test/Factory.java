package Test;

public class Factory {

	public static void main(String[] args) {
		Product phone = ProductFactory.getProduct("PC");
		if (null!=phone) {
			phone.work();
		}else {
			System.out.println("创建失败");
		}
	}

}
//工厂类:降低类与类之间的耦合
class ProductFactory{
	public static Product getProduct(String name) {
		if ("PC".equals(name)) {
			return new PC();
		}
		else if ("Phone".equals(name)) {
			return new Phone();
		}else {
			return null;
		}
	}
}

interface Product{
	void work();
}
class Phone implements Product{
	public void work() {
		System.out.println("手机工作。。。");
	}
}
class PC implements Product{
	public void work() {
		System.out.println("电脑开始工作....");
	}
}