package ThreadStudy;
/**
 * 守护线程案例
 * @author Administrator
 *
 */
public class DeamomStudy {
	public static void main(String[] args) throws InterruptedException {
		BBQ bbq = new BBQ();
		Thread t = new Thread(bbq);
		AAQ aaq = new AAQ();
		Thread t2 = new Thread(aaq);
		t2.setDaemon(true);
		t2.start();
		
		t.setDaemon(true);
		t.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"----"+i);
			Thread.sleep(100);
		}
	}
}
class BBQ implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"----"+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class AAQ implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"----"+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("down");
	}
	
}
