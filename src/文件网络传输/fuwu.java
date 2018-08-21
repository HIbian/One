package 文件网络传输;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class fuwu {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\test\\my\\sample.zip"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len=bis.read(buffer))!=-1) {
			bos.write(buffer,0,len);
			bos.flush();
		}
		bos.close();
		bis.close();
		socket.close();
		server.close();
	}
}
