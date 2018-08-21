package ThreadStudy;

import java.util.concurrent.locks.ReentrantLock;

public class 线程同步 {

	public static void main(String[] args) {
		窗口 窗口1 = new 窗口();

		Thread 窗口1线程 = new Thread(窗口1);
		Thread 窗口2线程 = new Thread(窗口1);
		窗口1线程.start();
		窗口2线程.start();

	}
}

class 窗口 implements Runnable {
	int 票的张数 = 10;
	ReentrantLock lock = new ReentrantLock();
	@Override
	public void run() {
		lock.lock();
		for (int 计数器 = 0; 计数器 < 300; 计数器++) {
			if (票的张数 > 0) {
				try {
					System.out.println("正在买出第" + 票的张数 + "张...");
					票的张数--;
					Thread.sleep(100);
				} catch (InterruptedException 异常对象) {
					异常对象.printStackTrace();
				}
			}
		}
		lock.unlock();
}
//	@Override
//synchronized	public void run() {
//			for (int 计数器 = 0; 计数器 < 300; 计数器++) {
//				if (票的张数 > 0) {
//					try {
//							System.out.println("正在买出第" + 票的张数 + "张...");
//							票的张数--;
//							Thread.sleep(100);
//					} catch (InterruptedException 异常对象) {
//						异常对象.printStackTrace();
//					}
//				}
//		}
//}
//	@Override
//public void run() {
//		
// 		synchronized (this) {
//			for (int 计数器 = 0; 计数器 < 300; 计数器++) {
//				if (票的张数 > 0) {
//					try {
//							System.out.println("正在买出第" + 票的张数 + "张...");
//							票的张数--;
//							Thread.sleep(100);
//					} catch (InterruptedException 异常对象) {
//						异常对象.printStackTrace();
//					}
//				}
//			}
//		}
//	}
}