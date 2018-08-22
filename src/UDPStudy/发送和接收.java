package UDPStudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 发送和接收 {
	public static void main(String[] args) throws IOException {
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//发送数据包
		byte[] buf = "llllllllllll".getBytes();
		DatagramPacket p = new DatagramPacket(buf,0, buf.length, InetAddress.getByName("127.0.0.1"),8080);
		datagramSocket.send(p);
		
		//接收数据包
		buf = new byte[1024];
		p = new DatagramPacket(buf,buf.length);
		datagramSocket.receive(p);//这应该是一个线程阻塞的方法
		System.out.println(new String(buf).trim());
	}
}
