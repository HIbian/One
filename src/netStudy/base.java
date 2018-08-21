package netStudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class base {
	public static void main(String[] args) throws UnknownHostException {
		//获取本机信息
		InetAddress iAddress = InetAddress.getLocalHost();
		//计算机名称以及ip地址
		System.out.println(iAddress.getHostName()+":"+iAddress.getHostAddress());
		
		//获取的域名对应的服务器的IP地址
		InetAddress byName = InetAddress.getByName("www.baidu.com");
		System.out.println(byName.getHostName()+":"+byName.getHostAddress());
		
		//获取对应域名的所有服务器的地址
		InetAddress[] allByName = InetAddress.getAllByName("www.bilibili.com");
		for (InetAddress inetAddress : allByName) {
			System.out.println("------------------");
			System.out.println(inetAddress.getHostAddress());
		}
		//验证一个ip地址是否正确,看是否抛出异常
		try {
			InetAddress byName2 = InetAddress.getByName("111.231.212.88");
			System.out.println(byName2);
		} catch (Exception e) {
			System.out.println("ip不正确");
		}
	}
}
