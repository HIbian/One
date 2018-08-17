package IOhomeworkWeekendsAdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目四:模拟用户登录功能实现。接收用户输入的用户名和密码，然后和文件中存储的用户名、密码匹配
 * @author Administrator
 *
 */
public class homework4 {
	public static void main(String[] args) throws IOException {
		//接收用户输入
		Scanner scan = new Scanner(System.in);
		System.out.println("输入用户名");
		String userName = scan.next();
		System.out.println("输入密码");
		String password = scan.next();
		scan.close();
		//读取文件到ArrayList中
		File file = new File("F:\\test\\login.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> info = new ArrayList<>();
		String string;
		while((string=br.readLine())!=null) {
			info.add(string);
		}
		br.close();
		//判断
		if ((info.get(0).equals("userName="+userName))&&(info.get(1).equals("password="+password))) {
			System.out.println("登陆成功");
		}else {
			System.out.println("登陆失败");
		}
	}
}
