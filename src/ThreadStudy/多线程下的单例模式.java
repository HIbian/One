package ThreadStudy;
//线程安全，不占资源
public class 多线程下的单例模式 {
	
}
class Myclass{
	private static Myclass my;
	private Myclass() {}
	public static Myclass getInstence() {
		if (my!=null) {
			return my;
		}
		synchronized (String.class) {
			if (my == null) {
				my = new Myclass();
			}
		}
		return my;
	}
}