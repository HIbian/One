package IOtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class ChangeStream {
	public static void main(String[] args) throws IOException{
		InputStream iStream = new FileInputStream("F:\\test\\1.txt");
		reader(iStream);
		
		System.out.println("-----------------");
		OutputStream outStream = new FileOutputStream("F:\\test\\1.txt");
		writter(outStream);
	}
	public static void reader(InputStream in) throws IOException{
		Reader rd = new InputStreamReader(in,Charset.forName("UTF-8"));
		char[] cs = new char[1024];
		int len = -1;
		while ((len=rd.read(cs))!=-1) {
			System.out.println(new String(cs,0,len));
		}
		rd.close();
	}
	public static void writter(OutputStream out) throws IOException{
		Writer wr = new OutputStreamWriter(out, Charset.forName("UTF-8"));
		String str = "柚子天下第一";
		char[] charArray = str.toCharArray();
		wr.write(charArray);
		wr.close();
	}
}

