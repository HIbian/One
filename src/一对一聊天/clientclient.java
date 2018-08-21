package 一对一聊天;//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 8080);
		Scanner scanner = new Scanner(System.in);
		String getInfo;
		String sendInfo;
		while(true) {
			//发送信息
			sendInfo = scanner.nextLine();//使用next不能使用空格
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(sendInfo);
			//接受信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			getInfo = br.readLine();
			System.out.println(getInfo);
		}
	}
}
