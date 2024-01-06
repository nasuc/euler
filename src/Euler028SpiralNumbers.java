/**
 * Euler problem 28
 * 
 * @author Alex
 *
 */
public class Euler028SpiralNumbers {

	public static void main(String[] args) throws InterruptedException {

		long st = Util.getClock();

		int size = 1001;

		System.out.println("Spiral size: " + size);
		System.out.println("Sum of diagonal numbers: " + spiralSum(size));
		System.out.println("Elapsed time (in miliseconds): " + Util.calculateDurationinNano(st) / 1000000);

	}

	private static long spiralSum(int step) {
		int sum = 0;
		if (step == 1)
			return 1;
		else
			sum += 4 * step * step - 6 * (step - 1) + spiralSum(step - 2);
		return sum;
	}

}
