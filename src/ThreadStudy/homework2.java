package ThreadStudy;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * b)计算任务，一个包含了2万个整数的数组，
 * 分拆了多个线程来进行并行计算，
 * 最后汇总出计算的结果。
 * @author Administrator
 *
 */
public class homework2 {
	public static HashMap<String, Integer> sumMap = new HashMap<>();
	public static void main(String[] args) throws InterruptedException {
		//20000
		int[] is = new int[20000];
		//赋值
		Random random = new Random();
		for (int i = 0; i < is.length; i++) {
			is[i] = random.nextInt(100);
		}
		//分为三个线程来计算
		//计算每个线程开始和结束的下标
		int c1_s = 0;
		int c1_e = 20000/3;
		int c2_s = c1_e;
		int c2_e = c2_s+c1_e;
		int c3_s = c2_e;
		int c3_e = is.length;
		//创建线程计算
		C c1 = new C(c1_s, c1_e, is);
		C c2 = new C(c2_s, c2_e, is);
		C c3 = new C(c3_s, c3_e, is);
		c1.start();
		c2.start();
		c3.start();
		while(!((c1.getIsfinished()&&c2.getIsfinished())&&c3.getIsfinished())) {
			Thread.sleep(200);
			System.out.println("...");
		}
		int sum = 0;
		Set<String> keySet = sumMap.keySet();
		for (String  s: keySet) {
			sum+= sumMap.get(s);
		}
		System.out.println(sum);
	}
}
class C extends Thread{
	private boolean isFinished = false;
	private int startNum;
	private int endNum;
	private int[] is;
	private int sunNum=0;
	public C(int startNum,int endNum,int[] is) {
		this.startNum = startNum;
		this.endNum = endNum;
		this.is = is;
	}
	public boolean getIsfinished() {
		return isFinished;
	}
	@Override
	public void run() {
		for (int i = startNum; i < endNum; i++) {
			sunNum +=is[i];
			
			if (i%200==0) {
				System.out.println(currentThread().getName() + "-" + sunNum);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}

		}
		homework2.sumMap.put(Thread.currentThread().getName(), sunNum);
		isFinished = true;
	}
}














