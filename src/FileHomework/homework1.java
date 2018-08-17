package FileHomework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class homework1 {
	public static void main(String[] args) throws IOException {
		//h1();
		//h2();
		//h3();
	}
	/**
	 * 一、指定文件的路径，要求得到：
				1.取得文件名
				2.取得文件路径
				3.得到绝对路径名
				4.得到父文件夹名
				5.判断文件是否存在
				6.判断文件是否可写
				7.判断文件是否可读
				8.判断是否是目录
				9.判断是否是文件	
				10．文件最后的修改时间
				11.文件的大小
	 */
	public static void h1() {
		File file = new File("F:\\test\\sample.zip");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile().getName());
		System.out.println(file.exists());
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
		System.out.println(file.length());
	}
	/**
	 * 二、
	1．在本地磁盘D盘中创建一个iotest文件夹

	2．在文件夹中创建一个以自己名字的拼音组成的文件名

	3．获取创建的这个文件的最后修改日期并打印到控制台

	4．将创建的这些文件和文件夹全部删除。
	 * @throws IOException 
	 */
	public static void h2() throws IOException {
		File file = new File("F:\\test\\iootest");
		file.mkdirs();
		File file2 = new File(file.getAbsolutePath()+"\\chenxin.txt");
		if (!file2.exists()) {
			file2.createNewFile();
		}
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file2.lastModified())));
		file2.delete();
		file.delete();
	}
	/**
	 * 三、
	1.在命令行(控制台)列出指定目录下的所有直接子文件和直接子目录

	2.用递归算法列出指定目录下的用户输入的子目录和文件并存入List集合中，将集合中的内容写入到指定的txt文档中。		
	
	3.递归删除指定文件夹中以“.txt”结尾的文件。
	 */
	static ArrayList<File> arrayFiles = new ArrayList<>();
	public static void h3() throws IOException {
		File file = new File("F:\\test");
		getFile(file);
		//写入文件
		File logfile = new File("F:\\test\\logfile.txt");
		Writer w = new FileWriter(logfile);
		for (int i = 0; i < arrayFiles.size(); i++) {
			w.write(arrayFiles.get(i).getAbsolutePath()+"\r\n");
		}
		w.close();
	}
	public static void getFile(File f) {
		if (f==null) {
			return;
		}else if (f.isFile()) {
			//删除txt
			if (f.getName().endsWith(".txt")) {
				f.delete();
				return;
			}
			//添加到集合
			arrayFiles.add(f);
			System.out.println(f.getAbsolutePath());
		}else if (f.isDirectory()) {
			File[] listFiles = f.listFiles();
			//添加到集合
			arrayFiles.add(f);
			System.out.println(f.getAbsolutePath());
			if (listFiles==null) {
				return;
			}
			for (File file : listFiles) {
				getFile(file);
			}
		}
	}

	
}


















