package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamInAndOut {
	public static void main(String[] args) throws IOException {
		Out();
		In();
	}
	public static void In() throws IOException {
		File a = new File("F:\\test\\wwwwwwww.txt");
		if (!a.exists()) {
			return;
		}
		FileInputStream fis = new FileInputStream(a);
		byte[] bs = new byte[8];
		StringBuilder sb = new StringBuilder();
		//这段默写有问题
		//需要注意byte转为String的方式
		//String构造器中有直接的方法
		int len = -1;
		while ((len=fis.read(bs))!=-1) {
			sb.append(new String(bs,0,len));
		}
		fis.close();
		System.out.println(sb);
		
	}
	
	public static void Out() throws IOException {
		//创建文件对象
		File a = new File("F:\\test\\wwwwwwww.txt");
		if (!a.exists()) {
			a.createNewFile();
		}
		//创建输出流对象
		FileOutputStream fos = new FileOutputStream(a);
		//输出内容
		String str = "coding is everyday";
		byte[] bs = str.getBytes();
		fos.write(bs);
		fos.close();
		System.out.println("done");
	}
}
