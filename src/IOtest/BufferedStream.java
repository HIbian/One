package IOtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class BufferedStream {
	public static void main(String[] args) throws IOException{
		byteWrite();
		byteReader();
		System.out.println("-----------------------------");
		charReader();
	}
	public static void byteWrite() throws IOException {
		//选择文件
		File file = new File("F:\\test\\1.txt");
		//构造输出流
		OutputStream oStream = new FileOutputStream(file);
		//构造一个字节缓冲流，加缓存
		BufferedOutputStream bStream = new BufferedOutputStream(oStream);
		String str = "缓冲流的输出输出。。。。。。。";
		bStream.write(str.getBytes());
		bStream.close();
		oStream.close();
	}
	public static void byteReader() throws IOException {
		File file = new File("F:\\test\\1.txt");
		InputStream iStream = new FileInputStream(file);
		//上面的InputStream一般作为参数传入
		BufferedInputStream bStream = new BufferedInputStream(iStream);
		byte[] bs = new byte[1024];
		int len = -1;
		while((len=bStream.read(bs))!=-1) {
			System.out.println(new String(bs,0,len));
		}
		bs.clone();
		iStream.close();	
	}
	public static void charReader() throws IOException {
		File file = new File("F:\\test\\1.txt");
//		InputStream iStream = new FileInputStream(file);
		Reader dr = new FileReader(file);
		//加缓存
		BufferedReader bReader = new BufferedReader(dr);
		char[] cs = new char[1024];
		int len = -1;
		while((len=bReader.read(cs))!=-1) {
			System.out.println(new String(cs,0,len));
		}
		bReader.close();
		dr.close();
	}
}
