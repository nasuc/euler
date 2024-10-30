public class Euler050ConsecutivePrimeSum {

	public static void main(String[] args) {

		Util.startClock();
		Number startingPrime = new Number(2L);
		Number sum = new Number(0L);
		Long maxLimit = 1000000L;
		Long sumMaxPrime = 2L;
		int sumMaxLength = 0;
		
		while (startingPrime.getValue() < maxLimit) {
			sum.setValue(startingPrime.getValue());
			Number nextPrime = new Number(startingPrime.getValue());
			int sumLength = 1;
			while (sum.getValue() <= maxLimit) {
				sumLength++;
				nextPrime = nextPrime.getNextPrime();
				sum.setValue(sum.getValue() + nextPrime.getValue());
				if (sum.isPrime() && sumLength > sumMaxLength) {
					sumMaxLength = sumLength;
					sumMaxPrime = sum.getValue();
					System.out.println("Max , length : " + sumMaxPrime + " , " + sumMaxLength );
				}
			}
			startingPrime = startingPrime.getNextPrime();
		}
		
		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

}
