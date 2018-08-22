package UDP一对一聊天;

import java.net.DatagramSocket;
import java.net.SocketException;

public class user1 {
	public static void main(String[] args) throws SocketException {
		DatagramSocket ds = new DatagramSocket(9090);
		new reciveThread(ds).start();
		new sendThread("零号", "127.0.0.1", 8080, ds).start();;
	}
}
