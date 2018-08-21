package netStudy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class eeecho {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner scan = new Scanner(System.in);
		//连接服务器
		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 8080);
		System.out.println("已经链接上了服务器...");
		System.out.println("输入要传入服务器的信息");
		String info = scan.next();
		scan.close();
		//输入信息
		PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
		ps.println(info);
		ps.flush();//确保立即写完到socket中
		//获取服务器返回信息
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String echo = br.readLine();
		System.out.println(echo);
		ps.close();
		br.close();
	}
}
