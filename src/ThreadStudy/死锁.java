package ThreadStudy;

public class 死锁 {
	public static void main(String[] args) {
		sou s1 = new sou(true);
		sou s2 = new sou(false);
		
		s1.start();
		s2.start();
		System.out.println("down");
	}
}
class sou extends Thread{
	private boolean bool;
	public sou() {}
	public  sou(boolean bool) {
		this.bool = bool;
	}
	@Override
	public void run() {
		if (bool) {
			synchronized ("1") {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {				}
				synchronized ("2") {
					System.out.println("111111执行了");
				}
			}
		}else {
			synchronized ("2") {
				synchronized ("1") {
					System.out.println("22222执行了");
				}
			}
		}
	}
}