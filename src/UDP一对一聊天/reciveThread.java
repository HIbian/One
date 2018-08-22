package UDP一对一聊天;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class reciveThread extends Thread {
	DatagramSocket socket;
	DatagramPacket p;
	public reciveThread(DatagramSocket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		while(true){
			try {
				byte[] buf = new byte[1024];
				p = new DatagramPacket(buf, buf.length);
				socket.receive(p);
				System.out.println(new String(buf).trim());
			} catch (Exception e) {
			}
		}
	}
}
