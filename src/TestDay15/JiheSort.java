package TestDay15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JiheSort {

	public static void main(String[] args) {
		
		ArrayList<Stu> stus = new ArrayList<>();
		stus.add(new Stu("bbbb", 68));
		stus.add(new Stu("cccc", 37));
		stus.add(new Stu("kkkk", 92));
		stus.add(new Stu("aaaa", 55));
		stus.add(new Stu("gggg", 67));
		for (Stu stu : stus) {
			System.out.println(stu);
		}
		System.out.println("----------------------");
		
		Comparator<Stu> compareName = new Comparator<Stu>() {
			@Override
			public int compare(Stu o1, Stu o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		
		Comparator<Stu> comperAge = new Comparator<Stu>() {
			@Override
			public int compare(Stu o1, Stu o2) {
				if (o1.getAge()>o2.getAge()) {
					return 1;
				}
				else if (o1.getAge()<o2.getAge()) {
					return -1;
				}
				return 0;
			}
		};
		
		Collections.sort(stus, compareName);
		for (Stu stu : stus) {
			System.out.println(stu);
		}
		
		System.out.println("------------------------------");
		Collections.sort(stus,comperAge);
		for (Stu stu : stus) {
			System.out.println(stu);
		}
	}

}

class Stu{

	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Stu() {}
	public Stu(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Stu [name=" + name + ", age=" + age + "]";
	}
}
