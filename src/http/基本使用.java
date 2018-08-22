package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class 基本使用 {
	public static void main(String[] args) throws IOException {
		//下载图片
		//链接对象，抛出链接不存在的异常
		URL url = new URL("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=971306493,1754244067&fm=11&gp=0.jpg");
		//获取通过url链接得到的对象
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//设置链接信息
		conn.setConnectTimeout(5000);//设置连接超时时间
		conn.setReadTimeout(5000);//设置读取连接超时时间
			//设置是否可用输入输出流
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");//POST安全性更高 GET
		
		//获取响应码
		int responseCode = conn.getResponseCode();
		
		if (responseCode == HttpURLConnection.HTTP_OK) {//连接成功
			//通过流读取图片资源
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("1.jpg"));
			byte[] buff = new byte[1024];
			int len = -1;
			while ((len =bis.read(buff))!=-1) {
				bos.write(buff, 0, len);
			}
			bos.close();
		} else {
			System.out.println(responseCode);
		}		
	}
}
