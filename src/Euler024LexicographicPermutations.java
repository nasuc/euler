import java.util.ArrayList;
import java.util.List;

public class Euler024LexicographicPermutations {

	public static void main(String[] args) {

		long st = Util.startClock();

		String str = "0123456789";
		// String str = "012";
		int nth = 999999;

		for (int factor : factoradic(nth, str.length())) {
			System.out.print(factor);
		}
		System.out.println();
		System.out.println("Nth permutation is: " + getNthPerm(str, factoradic(nth, str.length())));
		System.out.println("Elapsed time in miliseconds: " + Util.stopClock(st) / 1000000);

	}

	/**
	 * First permutation is 0. To get 100th permutation, use 99 as parameter for n
	 * 
	 * @param n
	 *            - the index of the permutation desired
	 * @param len
	 *            - the length of the array to be permuted
	 * @return
	 */
	static int[] factoradic(int n, int len) {
		int[] factoradicArray = new int[len];
		int i = 1;
		while (n != 0) {
			factoradicArray[len - i] = n % i;
			n = n / i;
			i++;
		}
		return factoradicArray;
	}

	static String getNthPerm(String str, int[] factoradicArray) {
		List<Object> chars = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			chars.add(str.charAt(i));
		}

		String output = "";
		for (int i = 0; i < str.length(); i++) {
			output += chars.get(factoradicArray[i]);
			chars.remove(factoradicArray[i]);
		}
		return output;
	}

}
