public class Euler043Substrings {
	
	static Long sum = 0L;

	public static void main(String[] args) {

		Util.startClock();

		permutation("0123456789");
		System.out.println("Sum : " + sum);

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) {
	    	if (isSolution(prefix)) {
	    		System.out.println("One solution : " + prefix);
	    		sum += Long.parseLong(prefix);
	    	}
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

	private static boolean isSolution(String pandigital) {
		Long num = Long.valueOf(pandigital.substring(7, 10));
		if (num % 17 != 0) {
			return false;
		}
		
		num = Long.valueOf(pandigital.substring(6, 9));
		if (num % 13 != 0) {
			return false;
		}
		
		num = Long.valueOf(pandigital.substring(5, 8));
		if (num % 11 != 0) {
			return false;
		}
		
		num = Long.valueOf(pandigital.substring(4, 7));
		if (num % 7 != 0) {
			return false;
		}
		
		num = Long.valueOf(pandigital.substring(3, 6));
		if (num % 5 != 0) {
			return false;
		}
		
		num = Long.valueOf(pandigital.substring(2, 5));
		if (num % 3 != 0) {
			return false;
		}
		
		num = Long.valueOf(pandigital.substring(1, 4));
		if (num % 2 != 0) {
			return false;
		}
		
		return true;
	}
	
	

}
