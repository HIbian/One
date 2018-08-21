package 文件网络传输;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class kehu {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket  = new Socket("127.0.0.1", 8080);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("F:\\test\\sample.zip")));
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = bis.read(buffer))!=-1) {
			bos.write(buffer,0,len);
		}
		bos.flush();
		bos.close();
		bis.close();
		socket.close();
	}
}
