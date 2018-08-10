package TestDay15;

public class ReserveInts {

	public static void main(String[] args) {
		int[] is = new int[] {1,3,5,7,9};
		int[] isR = new int[is.length];
		
		for (int i = 0; i < is.length; i++) {
			isR[i] = is[is.length-1-i];
		}
		for (int i : isR) {
			System.out.print(i+" ");
		}
	}
}
