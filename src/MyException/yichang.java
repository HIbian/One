package MyException;

public class yichang {
	public static void main(String[] args) {
		int i =0;
		try {
			if (i==0) {
				throw new MyException1();
			}
		} catch (MyException1 e) {
			System.out.println(e);
		}finally {
			System.out.println("-----------------------------");
		}
	}
}
