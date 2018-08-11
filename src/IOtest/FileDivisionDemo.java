package IOtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDivisionDemo {
	final static long DEFAULTSIZE = 1024*1024;
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\test\\sample.zip");
		TheDivision(file,DEFAULTSIZE*6);
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

	public static void merge() {

	}

}
