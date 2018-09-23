public class Euler027QuadraticPrimes {

	public static void main(String[] args) throws InterruptedException {

		long st = Util.startClock();

		int a = 0;
		int b = 0;
		int index = 0;
		int maxIndex = 0;
		int correctA = 0;
		int correctB = 0;
		Number quatraticrResult = new Number(0L);

		for (a = -999; a < 999; a++) {

			for (b = -1000; b <= 1000; b++) {

				boolean isNotEndOfConsecutivePrimes = true;
				index = 0;
				while (isNotEndOfConsecutivePrimes) {
					quatraticrResult = new Number(quatraticFormula(index, a, b));
					if (quatraticrResult.getValue() < 2) {
						isNotEndOfConsecutivePrimes = false;
					} else {
						isNotEndOfConsecutivePrimes = quatraticrResult.isPrime();
					}
					if (index > maxIndex) {
						maxIndex = index;
						correctA = a;
						correctB = b;
						System.out.println("We have a new max of primes: " + maxIndex);
						System.out.println("We have a new a: " + a);
						System.out.println("We have a new b: " + b);
						Thread.sleep(3000);
					}
					index++;
				}

				//System.out.println("Pair a, b, index : " + a + ", " + b + ", " + index);

			}
		}

		System.out.println("Number of primes generated " + maxIndex);
		System.out.println("a = " + correctA);
		System.out.println("b = " + correctB);
		System.out.println("Elapsed time in miliseconds: " + Util.stopClock(st) / 1000000);

	}

	private static long quatraticFormula(int index, int a, int b) {
		return index * (index + a) + b;
	}

}
