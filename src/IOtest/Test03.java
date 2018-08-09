package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {

	public static void main(String[] args) throws IOException{
		Out();
		In();
	}

	private static void In() throws IOException{
		//确定要读的对象
		File file = new File("F:\\test\\1.txt");
		//构建输入流对象
		FileInputStream is = new FileInputStream(file);
		//创建接受的字符数组
		byte[] bs = new byte[2048];
		//创建接受字符串
		StringBuilder builder = new StringBuilder();
		int len = -1;
		while ((len=is.read(bs))!=-1) {
			builder.append(new String(bs,0,len));
		}
		System.out.println(builder);
		//关闭输入
		is.close();
	}
	
	private static void Out() throws IOException{
		//确定目标文件
		File file = new File("F:\\test\\1.txt");
		//构建输出流对象
		FileOutputStream os = new FileOutputStream(file,true);//true代表追加而不是覆盖
		//写如信息
		String out = "文件输入输出流\r\n";//在windows中\r\n代表换行
		//写入文件，转换为字节数组
		os.write(out.getBytes());
		//关闭流
		os.close();
	}

}
