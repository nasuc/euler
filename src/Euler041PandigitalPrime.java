public class Euler041PandigitalPrime {

	public static void main(String[] args) {

		Util.startClock();

		permutation("7654321");

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) checkIfPrime(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

	private static void checkIfPrime(String pandigital) {
		Number num = new Number(Long.valueOf(pandigital));
		if (num.isPrime()) {
			System.out.println("Solution : " + pandigital);
			System.exit(0);
		}
	}
	

}
