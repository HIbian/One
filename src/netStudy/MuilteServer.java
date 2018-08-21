package netStudy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MuilteServer {
	public static void main(String[] args) throws IOException {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		@SuppressWarnings("resource")
		ServerSocket sockets = new ServerSocket(6666);
		System.out.println("服务器已启动，等待连接");
		//等待链接
		while (true) {
			//获取客户端
			Socket s = sockets.accept();
			System.out.println(s.getInetAddress().getHostAddress());
			//添加到线程池
			pool.execute(new UserThread(s));
		}
	}
}
class UserThread implements Runnable{
	private Socket s;
	
	public UserThread(Socket s) {
		this.s = s;
	} 
	public UserThread() {}
	@Override
	public void run() {
		try {
			BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream ps = new PrintStream(new BufferedOutputStream(s.getOutputStream()));
			String info = br.readLine();
			ps.println("echo:"+info);
			System.out.println(info);
//			ps.flush();
			ps.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}