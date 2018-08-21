package 一对一聊天优化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverserverserver {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		String sendInfo;
		Scanner scanner = new Scanner(System.in);
		//开辟新的线程接收消息
		SendMessage sm = new SendMessage(socket);
		sm.start();
		//使用main线程发送消息
		while(true){
			//发送信息
			sendInfo = scanner.nextLine();
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(sendInfo);
		}	
	}
}
class SendMessage extends Thread{
	private Socket socket;
	private String getInfo;

	public SendMessage() {
	}
	public SendMessage(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true) {
			try {
				//接受信息
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getInfo = br.readLine();
				System.out.println(getInfo);
			} catch (Exception e) {
			}
		}
	}
}