public class Euler021AmicableNumbers {

	public static void main(String[] args) {

		long st = Util.getClock();
		
		// Number number = new Number(76576500L);
				Long sum = 0L;
				for (long n = 4; n <= 10000; n++) {
					Number number = new Number(n);
					//System.out.println(number.getValue());
					Number sumOfProperDivisors = new Number(number.getSumOfDivisors());
					if (!number.getValue().equals(sumOfProperDivisors.getValue()) && sumOfProperDivisors.getSumOfDivisors().equals(number.getValue())) {
						System.out.println(number.getValue() + " is amicable numbe with " + sumOfProperDivisors.getValue());
						sum += number.getValue();
					}
				}

		System.out.println("Summ of all amiable numbers is " + sum);
		System.out.println("Elapsed time in miliseconds: " + Util.calculateDurationinNano(st) / 1000000);

	}



}
