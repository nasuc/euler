/**
 * Euler problem 30 - Digit fifth powers (brute force) Surprisingly there are
 * only three numbers that can be written as the sum of fourth powers of their
 * digits:
 * 
 * <li>1634 = 1^4 + 6^4 + 3^4 + 4^4
 * <li>8208 = 8^4 + 2^4 + 0^4 + 8^4
 * <li>9474 = 9^4 + 4^4 + 7^4 + 4^4
 * 
 * As 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth
 * powers of their digits.
 * 
 * @author Alex
 *
 */
public class Euler030FifthPowers {

	public static void main(String[] args) throws InterruptedException {

		long st = Util.getClock();

		int sumAllNumbers = 0;

		int sumDigits;
		for (int numInt = 10; numInt <= 354294; numInt++) {
			sumDigits = 0;
			String numString = Integer.toString(numInt);
			for (int i = 0; i < numString.length(); i++) {
				sumDigits += Math.pow(Integer.parseInt(String.valueOf(numString.charAt(i))), 5);
			}
			if (sumDigits == numInt) {
				System.out.println("Found a fith power number: " + numInt);
				sumAllNumbers += numInt;
			}
		}

		System.out.println("Sum of all numbers: " + sumAllNumbers);
		System.out.println("Elapsed time (in miliseconds): " + Util.calculateDurationinNano(st) / 1000000);

	}

}
