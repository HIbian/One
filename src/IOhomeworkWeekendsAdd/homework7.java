package IOhomeworkWeekendsAdd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * 题目七:在d盘目录下有一个加密文件a.txt（文件里只有英文和数字），
 * 密码是“heima”，当密码输入正确时才能读取文件里的数据。
 * 现要求用代码来模拟读取文件的过程，
 *  并统计文件里各个字母出现的次数，    
 *  并把统计结果按照“a：2个；b：3个；”的格式输出到d盘的count.txt中
 * @author Administrator
 *
 */
public class homework7 {
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\test\\mima.txt");
		FileReader fr = new FileReader(file);
		StringBuilder sb = new StringBuilder();
		char[] cbuf = new char[1024];
		int len = -1;
		while((len = fr.read(cbuf))!=-1) {
			sb.append(new String(cbuf,0,len));
		}
		fr.close();
		System.out.println("请输入密码");
		Scanner scan = new Scanner(System.in);
//		String pass = scan.next();
		scan.close();
		//判断密码是多少
		String realP = getPassword(sb);
		System.out.println(realP);
	}
	@Test
	public static String getPassword(StringBuilder string) {
		System.out.println(string);
		char[] charArray = string.toString().toCharArray();
		int index =0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i]==',') {
				break;
			}
			index++;
		}
		char[] ps = new char[index];
		return new String(ps);
	}
}
