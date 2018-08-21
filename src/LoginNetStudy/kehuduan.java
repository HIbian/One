package LoginNetStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class kehuduan {
	public static void main(String[] args) throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 8080);
		System.out.println("已连接服务器...");
		
		Scanner scanner  =new Scanner(System.in);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		System.out.println("请输入用户名");
		ps.println(scanner.next());
		System.out.println("请输入密码");
		ps.println(scanner.next());
		scanner.close();
		//获取返回结果
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String info = br.readLine();
		System.out.println(info);
	}
}
