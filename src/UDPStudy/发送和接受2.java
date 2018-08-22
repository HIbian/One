package UDPStudy;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class 发送和接受2 {
	public static void main(String[] args) throws Exception{
		//接收,先开启，等待对面发送
		DatagramSocket ds = new DatagramSocket(8080);//端口号
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf,buf.length);
		ds.receive(p);
		System.out.println(new String(buf).trim());
		//发送
		buf = "sbsbsbsbsbs".getBytes();
		p = new DatagramPacket(buf, 0, buf.length, p.getSocketAddress());//直接获取服务器的地址
		ds.send(p);
	}
}
