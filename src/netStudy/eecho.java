package netStudy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class eecho {
	public static void main(String[] args) throws IOException {
		//创建
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8080);
		System.out.println("服务器正在运行，等待连接...");
		Socket socket = server.accept();
		//已建立连接
		System.out.println("已建立连接");
		//接受客户端信息
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String info = br.readLine();
		System.out.println("客户端--->服务器:"+info);
		
		//发送信息给客户端
		PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
		ps.println("发送成功");
//		ps.flush();
		ps.close();
		br.close();
	}
}
