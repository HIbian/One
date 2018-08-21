package LoginNetStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginNetTest {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String userName = br.readLine();
		String passwd = br.readLine();
		
		PrintStream ps = new PrintStream(socket.getOutputStream());
		if ("chenxin".equals(userName)&&"123123".equals(passwd)) {
			ps.println("登陆成功");
		}else {
			ps.println("登陆失败");
		}
	}
}
