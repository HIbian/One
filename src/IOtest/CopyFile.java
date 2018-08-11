package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//指定一个文件将其复制到指定文件夹下
public class CopyFile {
	static int p =0;
	static int buffer_size = 1024;
	public static void main(String[] args) throws IOException {
//		源文件
//		File src = new File("E:\\Rili.java");
		String src = "F:\\百度云下載\\sample.zip";
//		目标
//		File target = new File("F:\\test\\");
		String target = "F:\\test\\";
		long startTime = System.currentTimeMillis();
		Copy(src, target);
		long endTime = System.currentTimeMillis();
		long costTime = endTime - startTime;
		System.out.println("cost:"+costTime/1000+"s");
	}
	
	public static void Copy(String src,String target) throws IOException {
		File scrFile = new File(src);
		File targetDir = new File(target);
		File copyedFile = new File(targetDir.getAbsolutePath()+"\\"+scrFile.getName());
		//输入是否合法
		if ((!scrFile.isFile())||(!targetDir.isDirectory())) {
			return;
		}
		//目录是否存在，不存在则创建
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		if (!copyedFile.exists()) {
			copyedFile.createNewFile();
		}
	    //获取文件大小
		long size_kb = scrFile.length()/1024;
		long hasCopyedSize_kb =0;
		
		//读取文件到缓冲区
		FileInputStream in = new FileInputStream(scrFile);
		FileOutputStream out = new FileOutputStream(copyedFile,true);//连续读写
		byte[] buffer = new byte[buffer_size];
		int len = -1;
		while ((len = in.read(buffer))!=-1) {
			out.write(buffer, 0, len);
			hasCopyedSize_kb+=buffer_size/1024;
			//进度条
			Progressibility(hasCopyedSize_kb, size_kb);
		}
		out.flush();
		out.close();
		in.close();
		
		System.out.println("done");
	}
	public static void Progressibility(long now,long total) {
		double pro = (double)now/(double)total;
		int t = p;
		p = (int)(pro*10);
		if (p!=t) {
			for (int i = 1; i <=p; i++) {
				System.out.print("▇");
			}
			System.out.println(p*10+"/100"+"\n");
		}
		
	}
}
