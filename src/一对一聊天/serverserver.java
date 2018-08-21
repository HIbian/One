package 一对一聊天;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverserver {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		String getInfo;
		String sendInfo;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			//接受信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			getInfo = br.readLine();
			System.out.println(getInfo);
			//发送信息
			sendInfo = scanner.nextLine();//使用next不能使用空格
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println(sendInfo);
		}
	}
}
