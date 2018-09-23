import java.math.BigInteger;

public class Euler025Fibonacci {

	public static void main(String[] args) {

		long st = Util.startClock();

		BigInteger prevFib = BigInteger.ONE;
		BigInteger temp = BigInteger.ONE;
		BigInteger fib = BigInteger.ONE;

		int index = 2;
		while (fib.toString().length() < 1000) {
			System.out.println(fib.toString());
			System.out.println(fib.toString().length());
			temp = fib;
			fib = fib.add(prevFib);
			prevFib = temp;
			index++;
		}

		System.out.println("Final Fibonacci is: " + fib);
		System.out.println("Index of Final Fibonacci is: " + (index));

		System.out.println("Elapsed time in miliseconds: " + Util.stopClock(st) / 1000000);

	}

}
