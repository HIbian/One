package IOtest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataStreamDemo {
	/**
	 * 利用java基本的数据类型进行读写操作，与机器无关
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		datastreamout();
		datastreamin();
	}
	public static void datastreamout() throws IOException {
		File file = new File("F:\\test\\2.txt");
		OutputStream os = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeInt(21111111);//写4字节
		dos.writeByte(111);//写1字节
		dos.writeChar('c');//写2字节
		dos.close();
	}
	public static void datastreamin() throws IOException {
		
		File file = new File("F:\\test\\2.txt");
		InputStream in = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(in);
		
		int i = dis.readInt();//读4字节
		byte b = dis.readByte();//读1字节
		char c = dis.readChar();//读2字节
		dis.close();
		System.out.println("i = "+i+"\tb = "+b+"\tc = "+c);
		
	}

}
