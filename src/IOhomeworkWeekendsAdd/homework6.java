package IOhomeworkWeekendsAdd;


/**
 * 题目六:在c盘下有一个txt文件,
 * 里面的文本内容包含”tmd”,”TMD”,”SB”等关键词,要求把读取出来的文本数据中”TMD”、
 * ”SB”的敏感字符以”**”或”***”代替,
 * 然后再输出到D盘的change.txt文本中
 * @author Administrator
 *
 */
public class homework6 {
	public static void main(String[] args) {
		String s1 = "112233tmd4422";
		char[] charArray = s1.toCharArray();
		for (int i = 0; i < charArray.length-3; i++) {
			if (isTmd(charArray[i],charArray[i+1],charArray[i+2])) {
				charArray[i]='*';
				charArray[i+1]='*';
				charArray[i+2]='*';
			}
		}
		System.out.println(new String(charArray));
		
	}
	public static boolean isTmd(char...cs) {
		if (cs[0]=='t'&&cs[1]=='m'&&cs[2]=='d') {
			return true;
		}
		return false;
	}
}
