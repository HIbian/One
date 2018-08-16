package IOhomework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 在C：下创建一个名为Letter的目录，用BufferedReader/BufferedWriter编写一个程序来显示下列选项：
 	1：撰写请假条
 	2：查看请假条
	根据用户的选择执行以下操作。
	如果所选的选项是“撰写请假条”，则应显示下列选项。
 	1、病假
	2、事假
	根据用户的选择，在所创建的当前工程Letter目录下创建一个名为Letter.txt的文件，其内容如下：	
	病假 我因发烧，请假一天
	事假 参见婚礼，于6.10请假一天
	请假人   用户输入
	请假日期 用户输入
	要求：根据不同的选择加入不同的请假理由/也可以自己手动加入理由 
              只需要手动加入请假人和请假日期（输入时使用转换流录入）
 * @author Administrator
 *
 */
public class homework7 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		System.out.println("1：撰写请假条\r\n" + 
									"2：查看请假条");
		Scanner scanner = new Scanner(System.in);
		String scan = scanner.next();
		switch(scan) {
			case "1":
					System.out.println("1、病假\r\n" 
											 + "2、事假");
					scan = scanner.next();
					switch (scan) {
						case "1":
							sb.append("病假:");
							System.out.println("1,发烧"
													+ "2,脚摔了"
													+ "3,被车撞了");
							scan = scanner.next();
							switch (scan) {
								case "1":sb.append("发烧");break;
								case "2":sb.append("脚摔了");break;
								case "3":sb.append("被车撞了");break;
								default:
									break;
							}
							break;
						case "2":
							sb.append("事假:");
							System.out.println("1,参加婚礼"
													+"2,参加葬礼"
													+"3,看望请病假的同志");
							scan = scanner.next();
							switch (scan) {
								case "1":sb.append("参加婚礼");break;
								case "2":sb.append("参加葬礼");break;
								case "3":sb.append("看望请病假的同志");break;
								default:
									break;
							}
							break;
						default:
							break;
					}
					//添加日期和姓名
					sb.append("，请假一天");
					System.out.println("请假人");
					sb.append("\r\n"+"请假人:"+scanner.next());
					System.out.println("请假时间");
					sb.append("\r\n"+"请假时间:"+scanner.next()+"\r\n");
					//存入文件
					WriteToFile(sb);
				break;
			case "2":
					ReadFile();
				break;
			default:
		}
		scanner.close();
	}
	public static void WriteToFile(StringBuilder sb) throws IOException {
		File file = new File("F:\\test\\Letter\\Letter.txt");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file,true));
		String str = new String(sb);
		bos.write(str.getBytes());
		bos.close();
	}
	public static void ReadFile() throws IOException {
		File file = new File("F:\\test\\Letter\\Letter.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		StringBuilder sb = new StringBuilder();
		byte[] bbuf = new byte[1024];
		int len = -1;
		while ((len = bis.read(bbuf))!=-1) {
			sb.append(new String(bbuf,0,len));
		}
		bis.close();
		System.out.println(sb);
	}
}
