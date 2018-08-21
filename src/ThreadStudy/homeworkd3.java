package ThreadStudy;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class homeworkd3 {
	public static void main(String[] args) throws InterruptedException {
		//设置文件路径
		File file = new File("F:\\test\\qjfs.jpg");
		File targetfile =new File("F:\\test\\my\\qjfs.jpg"); 
		//线程数
		int num =4;
		CopyThread[] cts = new CopyThread[num];
		//文件大小
		System.out.println("文件大小\t"+file.length());//22410712
		//获取余数
		int left = (int)(file.length()%num);
		System.out.println("余数\t"+left);
		//整除
		long copySize =(file.length()-left)/num;
		System.out.println("copySize\t"+copySize);
		long index = 0;
		//创建线程
		for (int i = 0; i < num; i++) {
			if(i==num-1) {
				cts[i]  = new CopyThread(index, index+copySize+left,file,targetfile);
				break;
			}
			cts[i]  = new CopyThread(index, index+copySize,file,targetfile);
			index+=copySize;
			continue;
		}
		//开启线程
		for (int i = 0; i < cts.length; i++) {
			cts[i].start();
		}
		//判断是否结束
		boolean is = true;
		while (is) {
			for (int i = 0; i < cts.length; i++) {
				if (!cts[i].getIsFinished()) {
					break;
				}
				if (i == cts.length - 1) {
					is = false;
				}
			} 
			Thread.sleep(1000);
		}
		System.out.println("FINISHED!");
		
	}
}
class CopyThread extends Thread{
	private boolean isFinished = false;
	private long s;
	private long e;
	private File file;
	private File targetfile;
	public CopyThread() {}
	public CopyThread(long s, long e, File file,File targetfile) {
		this.s = s;
		this.e = e;
		this.file = file;
		this.targetfile = targetfile;
	}
	public boolean getIsFinished() {
		return isFinished;
	}
	@Override
	public void run() {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			RandomAccessFile wraf = new RandomAccessFile(targetfile, "rw");
			raf.seek(s);
			wraf.seek(s);
			//System.out.println(s +" " + raf.getFilePointer());
			byte[] buf = new byte[1024];

			int len = -1;
			while ((len = raf.read(buf))!=-1) {
				wraf.write(buf, 0, len);
				//获取当前文件指针的方法getFilePointer
				if (e - raf.getFilePointer()<1024) {
					break;
				}
			}
			//读取剩余部分
			if (raf.getFilePointer()!=e) {
				byte[] bufleft = new byte[(int)(e-raf.getFilePointer())];
				len = raf.read(bufleft, 0, bufleft.length);
				wraf.write(bufleft, 0, bufleft.length);
			}

			raf.close();
			wraf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//表示该线程已经完成
		isFinished = true;
		System.out.println(Thread.currentThread().getName()+"已经完成...");
	}
}