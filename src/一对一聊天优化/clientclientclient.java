package 一对一聊天优化;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientclientclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 8080);
		String sendInfo;
		Scanner scanner = new Scanner(System.in);
		//开辟线程接收信息
		SendMessage sm = new SendMessage(socket);
		sm.start();
		//使用main线程发送信息
		while (true) {
			//发送信息
			sendInfo = scanner.nextLine();
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(sendInfo);
		}
	}
}
