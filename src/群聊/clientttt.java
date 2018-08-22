package 群聊;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientttt {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 8080);
		Scanner scanner = new Scanner(System.in);
		PrintStream ps = new PrintStream(socket.getOutputStream());
		//接受消息开辟一个新的线程
		new reciveThread(socket).start();
		//发送消息使用主线程
		while (true) {
			ps.println("陈昕"+scanner.next());
		}
	}
}
class reciveThread extends Thread{
	private BufferedReader br;
	
	public reciveThread() {
	}
	
	public reciveThread(Socket socket) {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String info = br.readLine();
				System.out.println(info);
			} catch (Exception e) {
			}
		}
	}
}




