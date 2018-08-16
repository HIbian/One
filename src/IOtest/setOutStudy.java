package IOtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class setOutStudy {
	public static void main(String[] args) throws FileNotFoundException{
		//文件->程序
		System.setIn(new FileInputStream("text.txt"));
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		scanner.close();
		System.out.println(next);
	}
}
