package IOtest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStream {
	/**
	 * 不是文件操作，在内存中进行的字节流操作，借鉴了文件流的方式
	 * 无需关闭
	 * @param args
	 */
	public static void main(String[] args) {
		byteArray();
	}
	public static void byteArray() {
		String str = "1112H***T^R%^$$%E%4w61";
		//创建输入字节流
		ByteArrayInputStream bas = new ByteArrayInputStream(str.getBytes());
		//创建输出字节流
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		int len =-1;//存储ASCII码
		while ((len=bas.read())!=-1) {
			//写入读出的字节流
			bao.write(len);
		}
		System.out.println(bao.toString());
	}
}
