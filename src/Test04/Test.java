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


package Test04;

import java.util.ArrayList;
import java.util.Iterator;

public class Test{
	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<>();
		aList.add("222");
		aList.add("111");
		aList.add("3");
		aList.add("1");
		aList.add("3322");
		
		aList.sort(null);

		Iterator<String> iterator = aList.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}