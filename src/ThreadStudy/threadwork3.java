package ThreadStudy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class threadwork3 {
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 采用多线程技术，改造之前的断点续传的案例，
		 * 实现多线程断点续传，要求线程的数量可由客户端程序来设置
		 */
		
		File sourceFile = new File("F:\\test\\qjfs.jpg");
		File targetFile = new File("F:\\test\\my\\qjfs.jpg");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入线程的数量：");
		int threadNum = scan.nextInt();
		
		long length = sourceFile.length()/threadNum;
		for (int i = 0; i < threadNum-1; i++) {
			new MT(sourceFile, targetFile, length*i, length).start();
		}
		
		long lastLength = sourceFile.length()/threadNum + sourceFile.length()%threadNum;
		new MT(sourceFile, targetFile, length*(threadNum-1), lastLength).start();
		
		scan.close();
	}
}
class MT extends Thread{
	
	private RandomAccessFile r;
	private RandomAccessFile w;
	private long length;//每个流要拷贝的字节数
	
	public MT(File sourceFile, File targetFile, long pointer, long length) throws IOException {
		this.r = new RandomAccessFile(sourceFile, "r");
		this.w = new RandomAccessFile(targetFile, "rw");
		this.length = length;
		
		this.r.seek(pointer);
		this.w.seek(pointer);
	}

	@Override
	public void run() {
		
		byte[] b = new byte[1024*10];
		int len;
		try {
			
			long sum = 0;//记录拷贝的字节数
			while((len = r.read(b)) != -1){
				w.write(b,0,len);
				sum += len;
				//多读无所谓，后面的会覆盖前面的（设置好了文件指针）；最后一段文件不会多读（len = -1）
				if(sum >= length){
					break;
				}
			}
		} catch (Exception e) {
		}finally {
			if(r != null){
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(w != null){
				try {
					w.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
