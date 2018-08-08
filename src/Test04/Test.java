package Test04;

import java.util.HashSet;
import java.util.Set;
public class Test {

	public static void main(String[] args) {	
		Set<Cat> set = new HashSet<>();
		set.add(new Cat("neko1", 1, 1));
		set.add(new Cat("neko2", 3, 2));
		set.add(new Cat("neko3", 3, 3));
		set.add(new Cat("neko4", 1, 4));
		set.add(new Cat("neko5", 2, 5));
		set.add(new Cat("neko5", 2, 5));
		System.out.println(new Cat("neko5", 2, 5).hashCode()%16);
		
		System.out.println(set.size());
		for (Cat cat : set) {
			System.out.println(cat);
		}
	}

}
