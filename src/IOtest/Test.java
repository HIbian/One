package IOtest;

import java.io.File;
import java.io.IOException;

public class Test {
	//github update....
	public static void main(String[] args) throws IOException {
		File file =  new File("F:\\test\\1.txt");
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建成功");
		}
//		file.delete();//删除文件
//		file.isFile();//是否为文件
//		file.isDirectory();//是否为文件夹
		
		File file2 = new File("F:\\test\\my");
		if (!file2.exists()) {
			file2.mkdirs();//创建路径
			System.out.println("ok");
		}
//		file.delete();//删除路径需要删除路径下所有文件
		String[] list = file2.list();//路径下所有文件和文件夹
		for (String string : list) {
			System.out.println(string);
		}
//		File[] listFiles = file2.listFiles();//返回file[]
//		listFiles[2].delete();
	}
}
