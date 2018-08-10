package IOtest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ZhiFuLiu {

	public static void main(String[] args) throws IOException {
		Wt();
		Rd();
	}
	
	public static void Rd() throws IOException{
		File aFile = new File("F:\\test\\qqqqqqqqq.txt");
		if (!aFile.exists()) {
			return;
		}
		FileReader fr = new FileReader(aFile);
		char[] cs = new char[50];
		int len = -1;
		StringBuilder sb = new StringBuilder();
		while((len=fr.read(cs))!=-1) {
			sb.append(new String(cs, 0, len));
		}
		fr.close();
		System.out.println(sb);
	}
	
	public static void Wt() throws IOException {
		File aFile = new File("F:\\test\\qqqqqqqqq.txt");
		if (!aFile.exists()) {
			aFile.createNewFile();
		}
		FileWriter fw = new FileWriter(aFile);
		String str = "Chorme is useful...";
		fw.write(str);
		fw.flush();
		fw.close();
		System.out.println("finished");
		
	}
}
