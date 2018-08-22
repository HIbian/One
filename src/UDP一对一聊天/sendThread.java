package UDP一对一聊天;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class sendThread extends Thread{
	String userName;
	String ip;
	int port;
	DatagramSocket socket;
	DatagramPacket p;
	
	public sendThread() {
	}
	
	public sendThread(String userName, String ip, int port, DatagramSocket socket) {
		this.userName = userName;
		this.ip = ip;
		this.port = port;
		this.socket = socket;
	}

	@Override
	public void run() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				byte[] buf = (userName +":"+scanner.next()).getBytes();
				//设定传输资源，长度，地址以及端口号
				p = new DatagramPacket(buf, 0, buf.length, InetAddress.getByName(ip),port);
				socket.send(p);
			} catch (Exception e) {
			}
		}
	}
}
