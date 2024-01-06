public class Euler037TruncatablePrimes {

	public static void main(String[] args) {

		Long sumOfTruncatableNUmbers = 0L;
		int countOfTruncatableNUmbers = 0;
		Number number = new Number(11L);
		
		while (countOfTruncatableNUmbers < 11) {
			if (number.isLeftTruncatable() && number.isRightTruncatable()) {
				System.out.println("Is truncatable: " + number.getValue());
				countOfTruncatableNUmbers++;
				sumOfTruncatableNUmbers += number.getValue();
			}
			number = number.getNextPrime();
		}
		
		System.out.println("Sum of truncatables: " + sumOfTruncatableNUmbers);

	}

}
