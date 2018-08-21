package zhuceStudy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 传对象
 * @author Administrator
 *
 */
public class fuwq {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		ObjectInputStream ois  =new ObjectInputStream(socket.getInputStream());
		Usertest u = (Usertest)ois.readObject();
		System.out.println(u.toString());
	}
}
