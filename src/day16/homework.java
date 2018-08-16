package day16;

import java.util.TreeSet;

public class homework {
//	给电脑排序
//
//排序规则：先按电脑的型号排序，型号相同按内存排(如果有固态硬盘，要加上固态硬盘内存的大小)
//
//要求：使用之前的冒泡排序，遍历输出(装进数组里)
//      使用set排序，遍历输出
// 
// 分析：电脑和固态硬盘的联系
//
//       通过接口关联固态硬盘
//
//       通过接口给电脑加固态硬盘内存大小(接口考虑有USB接口，没USB接口)
	public static void main(String[] args) {
		PC p1 = new PC("a1", 100);
		PC p2 = new PC("a1", 100);
		PC p3 = new PC("a2", 100);
		PC p4 = new PC("a2", 100);
		PC p5 = new PC("a3", 100);
		PC p6 = new PC("a3", 100);
		PC p7 = new PC("a3", 100);
		p1.addDivce(new SSD(20));
		p3.addDivce(new SSD(30));
		p6.addDivce(new SSD(50));
		p7.addDivce(new SSD(20));
		
		TreeSet<PC> pcs = new TreeSet<>();
		pcs.add(p6);
		pcs.add(p1);
		pcs.add(p2);
		pcs.add(p5);
		pcs.add(p3);
		pcs.add(p7);
		pcs.add(p4);

		for (PC pc : pcs) {
			System.out.println(pc);
		}
	}
}

interface Divce{}
interface USB{
	void addDivce(Divce obj);
}
class SSD implements Divce{
	int storage;

	public SSD() {}

	public SSD(int storage) {
		super();
		this.storage = storage;
	}
}

class PC implements USB,Comparable<PC>{
	String type;
	int storage;
	public PC() {}
	public PC(String type, int storage) {
		super();
		this.type = type;
		this.storage = storage;
	}
	@Override
	public void addDivce(Divce obj) {
		if (obj instanceof SSD) {
			this.storage+=((SSD) obj).storage;
		}
	}
	@Override
	public String toString() {
		return "PC [type=" + type + ", storage=" + storage + "]";
	}
	@Override
	public int compareTo(PC o) {
		if (!o.type.equals(this.type)) {
			return this.type.compareTo(o.type);
		}
		return this.storage-o.storage;
	}
}



