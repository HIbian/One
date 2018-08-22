package tttttttt;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("10.7.189.77", 7777);
			Scanner scan = new Scanner(System.in);
			while (true) {
				// 1.�����������Ϣ
				PrintStream ps = new PrintStream(socket.getOutputStream());
				ps.println("cx" + scan.next());
				
				new ClientThread(socket).start();
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
