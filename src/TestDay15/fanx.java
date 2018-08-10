package TestDay15;

import java.util.ArrayList;
import java.util.List;


public class fanx {
	public static void main(String[] args) {
		Kv<St>  kv= new Kv<>();
		
		kv.add(new St("1111"));
		kv.add(new St("cccc"));
		
		kv.name();
	}
}

class Kv<K>{
	List<K> ks=  new ArrayList<>();
	public void name() {
		for (K a : ks) {
			System.out.println(a);
		}
	}
	public void add(K k) {
		ks.add(k);
	}
}

class St{
	String name;

	public St() {
		super();
		// TODO Auto-generated constructor stub
	}

	public St(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "St [name=" + name + "]";
	}
	
}