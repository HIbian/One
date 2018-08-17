package IOhomeworkWeekendsAdd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class homework1 {
	public static void main(String[] args) {
		
	}
	/*
	 * 题目一: 将两个集合{“a”，“b”，“c”，“d”，“e”} 和{“d”，“e”，“f”，“g”，“h”},
	 * 把这两个集合去除重复项合并成一个,要求使用三种方法实现需求
	 */
	@Test
	public void homework1_() {
		ArrayList<String> strings1 = new ArrayList<>();
		ArrayList<String> strings2 = new ArrayList<>();
		strings1.add("a");
		strings1.add("b");
		strings1.add("c");
		strings1.add("d");
		strings1.add("e");
		strings2.add("d");
		strings2.add("e");
		strings2.add("f");
		strings2.add("g");
		strings2.add("h");
		//方法一
//		strings2.removeAll(strings1);
//		strings1.addAll(strings2);
		//方法二
/*		ArrayList<String> cStrings = new ArrayList<>();
		for (int i = 0; i < strings1.size(); i++) {
			for (int j = 0; j <strings2.size(); j++) {
				if (strings1.get(i).equals(strings2.get(j))) {
					cStrings.add(strings1.get(i));
					break;
				}
			}
		}
		strings1.addAll(strings2);
		for (int i = 0; i < cStrings.size(); i++) {
			for (int j = 0; j < strings1.size(); j++) {
				if (cStrings.get(i).equals(strings1.get(j))) {
					strings1.remove(j);
					break;
				}
			}
		}
*/
		//方法三
		for (int i = 0; i < strings2.size(); i++) {
			if (strings1.contains(strings2.get(i))) {
				strings1.remove(strings2.get(i));
			}
		}
		strings1.addAll(strings2);
		//打印
		for (String string : strings1) {
			System.out.println(string);
		}
	}
	/**
	 * 已知文件a.txt文件中的内容为“AAbcdea22dferwplkCC321ou1”,
	 * 请编写程序读取该文件内容，
	 * 要求去掉重复字母(区分大小写字母)并按照自然排序顺序后输出到b.txt文件中。
	 * 即b.txt文件内容应为"abc......123..."这样的顺序输出
	 * @throws IOException 
	 */
	@Test
	public void homework2() throws IOException {
		//读取文件
		File file = new File("F:\\test\\a.txt");
		Reader rd = new FileReader(file);
		StringBuilder sb = new StringBuilder();
		char[] cbuf = new char[6];
		int len = -1;
		while ((len = rd.read(cbuf))!=-1) {
			sb.append(cbuf, 0, len);
		}
		rd.close();
		
		
		char[] charArray = sb.toString().toCharArray();//转换为字符数组
		Arrays.sort(charArray);//利用工具类进行排序
		System.out.println(new String(charArray));
		//将不重复的加入ArrayList
		ArrayList<Character> cs = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			if (i==0) {
				cs.add(charArray[i]);
				continue;
			}
			if (charArray[i]==charArray[i-1]) {
				continue;
			}
			if (charArray[i]!=charArray[i-1]) {
				cs.add(charArray[i]);
			}
		}
		for (Character character : cs) {
			System.out.print(character);
		}
		//转一下
		char[] chars = new char[cs.size()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = cs.get(i);
		}
		//输出
		File file2 = new File("F:\\test\\b.txt");
		Writer w  =new FileWriter(file2);
		w.write(chars);
		w.close();
	}
	/**
	 * 题目三:把指定目录下(包含子目录)的所有图片，复制到另一个指定目录下
	 * @throws IOException 
	 */
	@Test
	public void h3() throws IOException {
		File file = new File("F:\\圖片");
		getFile(file);
		for (File listedfile : fileList) {
			System.out.println(listedfile.getAbsolutePath());
		}
		
		File file_copy = new File("F:\\test\\pic");
		file_copy.mkdirs();
		BufferedOutputStream bos;
		BufferedInputStream bis;
		for (int j = 0; j < fileList.size(); j++) {
			bos = new BufferedOutputStream(
					new FileOutputStream(file_copy.getAbsolutePath() + "\\" + fileList.get(j).getName()));
			bis = new BufferedInputStream(
					new FileInputStream(fileList.get(j)));
			byte[] bbuf = new byte[1024];
			int len=-1;
			while ((len= bis.read(bbuf))!=-1) {
				bos.write(bbuf, 0, len);
			}
		}
	}
	static ArrayList<File> fileList = new ArrayList<>();
	public static void getFile(File file) {
		if (file==null) {
			return;
		}
		if (file.isFile()) {
			if (file.getName().endsWith(".png")||file.getName().endsWith(".jpg")) {
				fileList.add(file);
			}
			return;
		}
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			if (listFiles==null) {
				return;
			}
			for (File file2 : listFiles) {
				getFile(file2);
			}
		}
	}
}
