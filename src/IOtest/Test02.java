package IOtest;

import java.io.File;

public class Test02{
	static int count =0;
	public static void main(String[] args) {
		FindFile(new File("E:\\"), ".txt");
		System.out.println("count="+count);
	}
	public static void FindFile(File target,String endsWith) {
		if (target==null) {
			return;
		}
		if (target.isFile()) {
			if (target.getName().endsWith(endsWith)) {
				count++;
				System.out.println(target.getAbsolutePath());
			}
		}
		if (target.isDirectory()) {
			File[] listFiles = target.listFiles();
			if (listFiles!=null) {
				for (File file : listFiles) {
					FindFile(file, endsWith);
				} 
			}
		}
	}
}

