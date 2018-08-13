package TestDay15;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CountNum {
	public static void main(String[] args) {
		HashMap<Character, Integer> hmp= new HashMap<>();
		String str = "abcddufiftttttufujjbjbhvhjkaarrrrx";
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (hmp.containsKey(charArray[i])) {
				hmp.replace(charArray[i], hmp.get(charArray[i])+1);
			}else {
				hmp.put(charArray[i], 1);
			}
		}
		Set<Entry<Character,Integer>> entrySet = hmp.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
	}
}
