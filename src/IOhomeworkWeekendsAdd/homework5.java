package IOhomeworkWeekendsAdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * 题目五:在c盘下有篇txt文本,
 * 读取这个文本并统计出这个文本中指定字符的个数(如指定字符为”我”),
 * 将该字符与对应的次数输出到当前项目的key.txt中,
 * 例如:输出格式为:我=10
 * @author Administrator
 *
 */
public class homework5 {

	public static void main(String[] args) throws IOException{
		//获取文件,读入
		File file = new File("F:\\test\\homework5.txt");
		char c = '1';
		//传入文件的编码格式
		Reader rd = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"));
		StringBuilder sb = new StringBuilder();
		char[] cs = new char[30];
		int len =-1;
		while ((len=rd.read(cs))!=-1) {
			sb.append(cs,0,len);
		}
		rd.close();
		System.out.println(sb);
		int count=0;
		char[] chars= sb.toString().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i]==c) {
				count++;
			}
		}
		System.out.println(c+"="+count);
	}
}
