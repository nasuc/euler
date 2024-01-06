public class Euler012TriangleNumbers {

	public static void main(String[] args) {
		Number no = new Number(0L);
		long st = Util.getClock();
		// Prime n = new Prime(4096000000000000000l);
		//Number n = new Number(32416187567l);
		// Prime n = new Prime(24L);

		Long index = 1L;
		Long triangleNumber = 1L;
		while (true) {
			index++;
			triangleNumber += index;
			no = new Number(triangleNumber);
			if (no.getNumberOfDivisors() >= 500) {
				System.out.println(triangleNumber);
				break;
			}
		}

		//System.out.println("Is " + n.getValue() + " prime ? : " + n.isPrime());
		//System.out.println("Prime divisors of " + n.getValue() + " : " + n.getPrimeDivisors());
		//System.out.println("Number of divisors of " + n.getValue() + " : " + n.getNumberOfDivisors());
		System.out.println("Elapsed time in miliseconds: " + Util.calculateDurationinNano(st) / 1000000);

	}

}
