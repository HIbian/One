package ThreadStudy;

/**
 * a)铁道部发布了一个售票任务，要求销售1000张票，
 * 要求有3个窗口来进行销售，
 * 请编写多线程程序来模拟这个效果
i.窗口001正在销售第1000张票
ii.窗口001正在销售第999张票
iii.窗口002正在销售第998张票
iv.。。。
v.窗口002正在销售第1张票
vi.票已经销售完毕
 * @author Administrator
 *
 */
public class sell {
	public static int left = 100;
	public static void main(String[] args) {
		wins w1 = new wins("窗口1");
		wins w2 = new wins("窗口2");
		wins w3 = new wins("窗口3");
		w1.start();
		w2.start();
		w3.start();
	}
}
class wins extends Thread{
	
	//设置线程的名字
	public wins(String names) {
		super.setName(names);
	}
	@Override
	public void  run() {
			while (sell.left > 0) {
				
				synchronized (String.class) {
					System.out.println(Thread.currentThread().getName() + "正在销售第" + sell.left + "张票");
					sell.left--;
					if (sell.left == 0) {
						System.out.println(Thread.currentThread().getName() + "票已经销售完毕");
					}
				}
				
			}
	}
}