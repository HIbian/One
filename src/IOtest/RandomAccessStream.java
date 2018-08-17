package IOtest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class RandomAccessStream {
	//利用随机访问流向文件写入数据
	@Test
	public void write() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("F:\\test\\raf.txt"), "rw");
		raf.write("123123rrrrre谔谔".getBytes());
		raf.close();
	}
	//读取数据
	@Test
	public void read() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(new File("F:\\test\\raf.txt"), "r");
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = raf.read(buffer))!=-1) {
			System.out.println(new String(buffer,0,len));
		}
		raf.close();
	}
	//直接从英文字符处读取数据
	@Test
	public void read1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("F:\\test\\raf.txt"), "r");
		raf.seek(6);//下标为6
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len = raf.read(buffer))!=-1) {
			System.out.println(new String(buffer,0,len));
		}
		raf.close();
	}
	//如果不设置指针，写入还是从0下标开始，覆盖该下标上的数据，其他数据不变
	@Test
	public void write1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("F:\\test\\raf.txt"), "rw");
		raf.write("bb".getBytes());
		raf.close();
	}
	//文件末尾追加信息
	@Test
	public void write2() throws IOException {
		File file = new File("F:\\test\\raf.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(file.length());
		raf.write("bb".getBytes());
		raf.close();
	}
	//copy,断点续传原理
	@Test
	public void copyfile() throws IOException{
		File file = new File("F:\\test\\raf.txt");
		File file_copy = new File("F:\\test\\raf-copy.txt");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		RandomAccessFile raf2 = new RandomAccessFile(file_copy, "rw");
		
		//设置指针
		raf.seek(file_copy.length());
		raf2.seek(file_copy.length());
		
		byte[] bbuf = new byte[2];
		int len = -1;
		while((len=raf.read(bbuf))!=-1) {
			raf2.write(bbuf, 0, len);
		}
		raf.close();
		raf2.close();
	}
}
