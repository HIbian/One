package IOtest;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class PrintStreamDemo {
	public static void main(String[] args) throws IOException {
		bytePrint("dayi12上证综指");
		charPrint("222222233333333333");
	}
	public static void bytePrint(Object object) throws IOException {
		File file = new File("F:\\test\\1.txt");
		OutputStream out = new FileOutputStream(file);
		//加缓存
		BufferedOutputStream bos = new BufferedOutputStream(out);
		//增强打印
		PrintStream pStream = new PrintStream(bos);
		pStream.println(object);
		pStream.println("2222");
		pStream.close();
		bos.close();
		out.close();
	}
	public static void charPrint(Object object) throws IOException{
		File file = new File("F:\\test\\2.txt");
		Writer wr = new FileWriter(file);
		//加缓存
		BufferedWriter bWriter = new BufferedWriter(wr);
		//增强打印
		PrintWriter pw = new PrintWriter(bWriter);
		pw.println(object);
		pw.close();
		bWriter.close();
		wr.close();
		
	}
}
