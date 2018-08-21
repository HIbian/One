package netStudy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ECHOServerDemo {
	public static void main(String[] args) throws IOException {
		//创建服务器并且指定端口号
		ServerSocket server = new ServerSocket(6666);
		System.out.println("服务器已经启动，等待连接");
		//等待客户端连接，线程阻塞
		Socket socket = server.accept();
		System.out.println("连接成功:"+server.getInetAddress().getHostAddress());
		//读取客户端数据
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String info = br.readLine();
		System.out.println("服务器端info："+info);
		
		//返回数据
		PrintStream ps = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
		ps.println("echo"+info);
		ps.flush();
		ps.close();
		br.close();
		server.close();
	}
}
