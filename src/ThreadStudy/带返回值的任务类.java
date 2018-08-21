package ThreadStudy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class 带返回值的任务类 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//结合线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		//获取返回值
		//添加到线程池   此处会进入线程柱塞状态
		Future<Integer> f1 = pool.submit(new tasks());
		Future<Integer> f2 = pool.submit(new tasks());
		Future<Integer> f3 = pool.submit(new tasks());
		
		//get用于获取返回值
		System.out.println( f1.get()+" "+f2.get()+" "+f3.get());
		//关闭线程
		pool.shutdown();
	}
}
//需要实现Callable接口，泛型为返回值类型
class tasks  implements Callable<Integer>{
	int sum = 0;
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < 100; i++) {
			sum+= i;
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println(Thread.currentThread().getName()+"----------"+sum);
		return sum;
	}
}
