package IOhomework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class homework1{

	public static void main(String[] args) throws IOException{
		//work1();
		//work2();
		//work3();
		//System.out.println(MyStringUtil.getSingleString("ee2e22121r1rr1r122ww"));
		//System.out.println(MyStringUtil.isBalancedString("abaaaaaaba"));
		//System.out.println(MyStringUtil.toCharArray("21e21e12e1e").toString());
		
	}
	/*
	 * 一、字节流。
	 *1．已知电脑D盘有iotest文件夹[没有的话自己手动建一个]在里面新建一个Stream.txt文件
	 *2．用输出流FileOutputStream向Stream.txt文件中写入"I love you!"
	 *3．用输入流FileInputStream读取获Stream.txt这个文件内容并打印到控制台
	 */
	public static void work1() throws IOException {
		File file = new File("F:\\test\\Stream.txt");
		OutputStream os = new FileOutputStream(file);
		String str = "I love you!";
		os.write(str.getBytes());
		os.close();
		InputStream in = new FileInputStream(file);
		
		StringBuilder string=new StringBuilder();
		byte[] bs =new byte[2];
		int len = -1;
		while ((len = in.read(bs))!=-1) {
			string.append(new String(bs, 0, len));
		}
		in.close();
		System.out.println(string);
	}
	/**二、字符流
	 * 1．已知电脑D盘有iotest2文件夹[没有的话自己手动建一个]在里面新建一个Stream.txt文件
	 * 2．用输出流FileWriter 向Stream.txt文件中写入"I love you!"
	 * 3．用输入流FileReader 读取获Stream.txt这个文件内容并打印到控制台
	 * 4．用FileWriter和FileReader完成文件的复制[把Stream.txt复制到C盘的根目录下]
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private static void work2() throws IOException {
		File file = new File("F:\\iotest2\\Stream.txt");
		FileWriter fWriter = new FileWriter(file);
		String str = "I love you!";
		fWriter.write(str);
		fWriter.close();
		FileReader fReader = new FileReader(file);
		StringBuilder sb=new StringBuilder();
		char[] cs = new char[2];
		int len = -1;
		while ((len=fReader.read(cs))!=-1) {
			sb.append(cs, 0, len);
		}
		fReader.close();
		System.out.println(sb);
	}
	/**
	 * 三、缓冲字符流
	 * 1．已知电脑D盘有iotest3文件夹在里面新建一个Stream.txt文件
	 * 2．用输出流BufferedWriter 向Stream.txt文件中写入"我叫XXX,性别:男,出生年月:XXXXX''"
	 * 3．用输入流BufferdeReader 读取获Stream.txt这个文件内容并打印到控制台
	 * 4．用BufferedWriter 和BufferdeReader 完成文件的复制
	 */
	public static void work3() throws IOException{
		//缓冲字节流
//		File file = new File("F:\\iotest2\\Stream.txt");
//		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
//		String str = "我叫xxx，性别x，出生年月：xxxxxx";
//		bos.write(str.getBytes());
//		bos.close();
//		
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//		byte[] bs = new byte[1024];
//		StringBuilder sb =new StringBuilder();
//		int len = -1;
//		while ((len = bis.read(bs))!=-1) {
//			sb.append(new String(bs,0,len));
//		}
//		bis.close();
//		System.out.println(sb);
		File file = new File("F:\\iotest2\\Stream.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		String str = "我叫xxx，性别x，出生年月：xxxxxx";
		bw.write(str);
		bw.close();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		char[] cs = new char[2];
		int len = -1;
		while ((len = br.read(cs))!=-1) {
			sb.append(new String(cs, 0, len));
		}
		br.close();
		System.out.println(sb);
	}
}
/**
 * 
 *	四、按需求完成指定功能，题目如下 ： 
 *	定义一个MyStringUtil工具类，该类中定义三个方法，要求如下：
 * 	
 *	(1)去除给定的参数字符串中的重符字符（重复字符只保留一个），将新的字符串返回
 *		public static String getSingleString(String str)
 *	
 *	(2)如果左右两边字符相同则返回true，否则返回false，例如：abccba是对称字符：
 *		public static boolean isBalancedString(String str) 
 *		* 例如：abcdecba不是对称字符
 *
 *	(3)将给定的参数字符串转成对应的字符数组（不能直接调用jdk中的工具类及String类中的tocharArray方法） 
 *	public static char[] toCharArray(String str)
 */
class MyStringUtil{
	public static String getSingleString(String str) {
		char[] charArray = str.toCharArray();
		ArrayList<Character> cs = new ArrayList<>();
		
		for (int i = 0; i < charArray.length; i++) {
			if (cs.contains((Character)charArray[i])) {
				continue;
			}
			cs.add(charArray[i]);
		}
		char[] c = new char[cs.size()];
		for (int i = 0; i < c.length; i++) {
			c[i] = cs.get(i);
		}
		String reString= new String(c);
		return reString;
	}
	public static boolean isBalancedString(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length/2+1; i++) {
			if (charArray[i]==charArray[charArray.length-i-1]) {
				continue;
			}
			return false;
		}
		return true;
	}
	public static char[] toCharArray(String str) {
		char[] cs = new char[str.length()];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = str.charAt(i);
		}
		return cs;
	}
}






















