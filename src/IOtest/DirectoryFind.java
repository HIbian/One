package IOtest;

import java.io.File;

public class DirectoryFind {
	static int Count =0;
	public static void main(String[] args) {
		File f = new File("F:\\");
		String key = ".txt";
		find(f, key);
		System.out.println("Count="+Count);
	}
	
	public static void find(File f,String key) {
		if (!f.exists()) {
			return;
		}
		if (f.isFile()) {
			if (f.getName().endsWith(key)) {
				Count++;
				System.out.println(f.getAbsolutePath());
			}
			return;
		}
		if (f.isDirectory()) {
			File[] listFiles = f.listFiles();
			if (listFiles==null) {
				return;
			}
			for (File file : listFiles) {
				find(file, key);
			}
		}
	}
}
