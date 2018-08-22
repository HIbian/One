package UDP一对一聊天;

import java.net.DatagramSocket;
import java.net.SocketException;

public class user2 {
	public static void main(String[] args) throws SocketException {
		DatagramSocket ds = new DatagramSocket(8080);
		new reciveThread(ds).start();
		new sendThread("一号", "127.0.0.1", 9090, ds).start();;
	}
}
