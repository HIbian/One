package netStudy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ECHODemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//创建Socket对象，连接指定服务器
		Socket socket = new Socket("localhost", 6666);
		Scanner input = new Scanner(System.in);
		//向服务器发送数据
		PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
		ps.println(input.next());
		ps.flush();
		//读取服务器取回数据
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String info =  br.readLine();
		ps.close();
		br.close();
		System.out.println(info);
		socket.close();
	}
}









