package day16;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMap_TreeSet {
	public static void main(String[] args) {
		
		TreeSet<String> tSet = new TreeSet<>();
		tSet.add("22");
		tSet.add("33");
		tSet.add("00");
		tSet.add("11");
		tSet.add("44");
		tSet.add("99");
		tSet.add("66");
		tSet.add("88");
		tSet.add("77");
		
		System.out.println(tSet.isEmpty());
		System.out.println(tSet.size());
		System.out.println(tSet.remove("44"));
		System.out.println(tSet.contains("44"));
		System.out.println(tSet.contains("00"));
		
		
		for (String string : tSet) {
			System.out.println(string);
		}
		System.out.println("------------------------------");
		Iterator<String> iterator = tSet.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("-----------------------------------------");
		TreeMap<String, Integer> tMap =  new TreeMap<>();
		tMap.put("ee", 12);
		tMap.put("32", 32);
		tMap.put("ec", 33);
		tMap.put("qs", 22);
		tMap.put("cc", 33);
		tMap.put("vv", 1);
		tMap.put("efefw", 152332);
		tMap.put("evvev", 352234);
		tMap.put("asdssa", 21444);
		
		Set<String> keySet = tMap.keySet();
		for (String string : keySet) {
			System.out.println(string+"---"+tMap.get(string));
		}
		System.out.println("----------------------------------------------");
		Set<Entry<String,Integer>> entrySet = tMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"-----"+entry.getValue());
		}
		
		
		
		
		
	}
}
