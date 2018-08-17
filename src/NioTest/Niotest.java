package NioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.junit.Test;

public class Niotest {
	/**
	 * Java NIO 由以下几个核心部分组成：
	Buffers -- 缓冲区 ：针对系统的缓冲区
	Channels -- 通道 ： 类似于BIO里面的流
	Selectors -- 选择器
	 */
	public static void main(String[] args) {

		
		
	}
	//一次性拷贝
	@Test
	public void copy1() throws Exception{
		File  file= new File("F:\\test\\Letter\\Letter.txt");
		File file_copy = new File("F:\\test\\Letter\\Letter-copy.txt");
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file_copy);
		
		FileChannel readC = fis.getChannel();
		FileChannel writeC = fos.getChannel();
		
		ByteBuffer bb = ByteBuffer.allocate((int)file.length());
		
		readC.read(bb);
		bb.flip();//一定要反转
		writeC.write(bb);
		
		fis.close();
		fos.close();
	}
	//每次读取1024字节拷贝
	@Test
	public void copy2() throws Exception{
		File  file= new File("F:\\test\\sample.zip");
		File file_copy = new File("F:\\test\\sample-copy.zip");
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(file_copy);
		
		FileChannel readC = fis.getChannel();
		FileChannel writeC = fos.getChannel();
		
		ByteBuffer bb = ByteBuffer.allocate(1024);

		while(readC.read(bb)!=-1) {
			bb.flip();
			writeC.write(bb);
			bb.clear();
		}
		fis.close();
		fos.close();
	}
	//Map映射
	@Test
	public void copy3() throws Exception{
		File  file= new File("F:\\test\\Letter\\sample.zip");
		File file_copy = new File("F:\\test\\Letter\\sample-copy.zip");
		
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		RandomAccessFile rafw = new RandomAccessFile(file_copy, "rw");
		
		FileChannel readC = raf.getChannel();
		FileChannel writeC = rafw.getChannel();
		
		MappedByteBuffer rmap = readC.map(MapMode.READ_ONLY, 0, file.length());
		MappedByteBuffer wmap = writeC.map(MapMode.READ_WRITE, 0, file.length());
		
		for (int i = 0; i < (int)file.length(); i++) {
			byte b = rmap.get(i);
			wmap.put(b);
		}
		raf.close();
		rafw.close();
	}
	@Test
	public void testbuffer() {
		//创建缓冲区
		ByteBuffer bb = ByteBuffer.allocate(12);
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(bb.remaining());
		//存数据
		bb.put("2233bhjiuygf".getBytes());
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(bb.remaining());
		//反转
		bb.flip();
		System.out.println(bb.position());
		System.out.println(bb.limit());
		System.out.println(bb.capacity());
		System.out.println(bb.remaining());
		//获取元素
		for (int i = 0; i < bb.remaining(); i++) {
			System.out.print((char)bb.get(i));
		}
	}
	//使用NIO:让BIO的对象调用获取通道的方法
	public void test001() throws Exception {
		FileInputStream fis = new FileInputStream("F:\\test\\1.txt");
		FileChannel channel = fis.getChannel();
		channel.close();
		fis.close();
	}
	
	
	
	
}
