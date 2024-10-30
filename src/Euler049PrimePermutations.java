public class Euler049PrimePermutations {

	public static void main(String[] args) {

		Util.startClock();
		Number number = new Number(0L);
		int delta = 3330;
		
		for (long n = 1489L; n<=3339; n++) {
			number.setValue(n);
			if (number.isPrime()) {
				Number number2 = new Number(n + delta);
				if (number2.isPrime() && number.hasSameDigits(number2.getValue())) {
					Number number3 = new Number(n + 2 * delta);
					if (number3.isPrime() && number.hasSameDigits(number3.getValue())) {
						System.out.println("Found : " + n + number2.getValue() + number3.getValue());
						break;
					}
				}
			}
		}
		

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

}
