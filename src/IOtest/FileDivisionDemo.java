package IOtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;


public class FileDivisionDemo {
	final static long DEFAULTSIZE = 1024*1024;
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\test\\sample.zip");
		TheDivision(file,DEFAULTSIZE*5);
		merge();
	}

	/**
	 * 文件分割
	 * 
	 * @param file    要分割的文件
	 * @param cutsize 分割后每个文件的大小
	 * @throws IOException
	 */
	public static void TheDivision(File file, long cutsize) throws IOException {
		// 判断文件是否存在
		if (file == null) {
			return;
		}
		// 计算分割的个数
		int num = (file.length() % cutsize == 0) ? (int) (file.length() / cutsize)
				: (int) (file.length() / cutsize + 1);
		// 文件输入流
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		//文件输出流
		BufferedOutputStream out = null;
		//每次读取长度
		byte[] bytes = null;
		//每次读取实际长度
		int len = -1;
		//每次分割需要读取的次数
		int count = 0;
		
		for (int i = 0; i < num; i++) {
			out = new BufferedOutputStream(new FileOutputStream(new File("F:\\test\\"+(i+1)+"---"+file.getName())));
			if (cutsize<DEFAULTSIZE) {//每次分割大小小于1024
				bytes = new byte[(int)cutsize];
				count =1;
			}else {
				bytes = new byte[(int)DEFAULTSIZE];
				count = (int)cutsize/(int)DEFAULTSIZE;//分割文件需要搬运的次数
			}
			//输出分割文件
			while(count>0&&((len=in.read(bytes))!=-1)) {
				out.write(bytes,0,len);
				out.flush();//
				count--;
			}
			//输出剩余的分割文件
			if (cutsize%DEFAULTSIZE!=0) {
				//不能读取多了,数组大小刚好为剩余部分的大小
				bytes = new byte[(int)cutsize%(int)DEFAULTSIZE];
				in.read(bytes);
				out.write(bytes,0,bytes.length);
				out.flush();
			}
			out.close();
		}
		in.close();	
	}

	public static void merge() throws IOException {
		InputStream in1 = new FileInputStream(new File("F:\\test\\1---sample.zip"));
		InputStream in2 = new FileInputStream(new File("F:\\test\\2---sample.zip"));
		InputStream in3 = new FileInputStream(new File("F:\\test\\3---sample.zip"));
		InputStream in4 = new FileInputStream(new File("F:\\test\\4---sample.zip"));
		InputStream in5 = new FileInputStream(new File("F:\\test\\5---sample.zip"));
		Vector<InputStream> v = new Vector<>();
		v.add(in1);
		v.add(in2);
		v.add(in3);
		v.add(in4);
		v.add(in5);
		Enumeration<InputStream> es = v.elements();
		//合并流
		SequenceInputStream sis = new SequenceInputStream(es);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("F:\\sample.zip")));
		byte[] bs = new byte[1024];
		int len = -1;
		while ((len=sis.read(bs))!=-1) {
			bos.write(bs, 0, len);
		}
		
		bos.close();
		sis.close();
		System.out.println("done");
		
	}

}
