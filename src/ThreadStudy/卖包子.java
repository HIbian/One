package ThreadStudy;

import java.util.Random;

public class 卖包子 {
	public static void main(String[] args) {
		
	}
}
class BaoziWin extends Thread{
	private static int baozi = 100;
	Random r = new Random();
	@Override
	public void run() {
		while (baozi>0) {
			baozi-=r.nextInt(5);
			System.out.println(baozi);
		}
	}
}