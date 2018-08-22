package 群聊;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

//tcp/ip
public class servserssss {
	public static HashMap<String, Socket> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		
		while (true) {
			//获取客户端socket
			Socket socket = server.accept();
			//获取客户端ip
			String ip = socket.getInetAddress().getHostAddress();
			map.put(ip, socket);
			new serverThread(socket, ip).start();
		}
		
	}
}
class serverThread extends Thread{
	private BufferedReader br;
	private String ip;
	
	public serverThread() {
	}
	
	public serverThread(Socket socket, String ip) throws IOException {
		this.ip = ip;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	@Override
	public void run() {
		while (true) {
			try {
				//接受消息
				String info = br.readLine();
				//给其他客户端发送消息
				HashMap<String, Socket> hmp = servserssss.map;
				Set<String> keySet = hmp.keySet();
				for (String string : keySet) {
					if (!string.equals(ip)) {
						PrintStream ps = new PrintStream(hmp.get(string).getOutputStream());
						ps.println(info);
					}
				}
			} catch (Exception e) {
			}
		}
	}
}




