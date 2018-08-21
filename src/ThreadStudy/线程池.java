package ThreadStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程池 {
	public static void main(String[] args) {
		//一个线程的线程池
//		ExecutorService pool = Executors.newSingleThreadExecutor();
		//固定线程的线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		//带有缓存区的线程池
//		ExecutorService pool = Executors.newCachedThreadPool();
		
		//添加到线程池
		pool.submit(new task());
		pool.submit(new task());
		pool.submit(new task());
		
		//关闭线程池
		pool.shutdown();
		
	}
}

class task implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"--------"+i);
		}
	}
}