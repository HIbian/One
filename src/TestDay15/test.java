package TestDay15;

import java.util.HashMap;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		HashMap<Teacher, Student[]> hmp = new HashMap<>();
		
		Teacher t1 = new Teacher("t1");
		Teacher t2 = new Teacher("t2");
		Teacher t3 = new Teacher("t3");
		
		Student s1 = new Student("s1");
		Student s2 = new Student("s2");
		Student s3 = new Student("s3");
		Student s4 = new Student("s4");
		Student s5 = new Student("s5");
		Student s6 = new Student("s6");
		
		hmp.put(t1,new Student[]{s1,s2,s3,s4,s5,s6});
		hmp.put(t2,new Student[]{s1,s2});
		hmp.put(t3,new Student[]{s1,s2,s5,s6});
		
		//遍历
		Set<Teacher> keySet = hmp.keySet();
		for (Teacher teacher : keySet) {
			System.out.println(teacher.name+" ...");
			for (Student student : hmp.get(teacher)) {
				System.out.println(student);
			}
		}
	}
}

class Teacher{
	String name;

	public Teacher(String name) {
		super();
		this.name = name;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + "]";
	}
	
}
class Student{
	
	String name;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
}