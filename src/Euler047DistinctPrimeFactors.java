public class Euler047DistinctPrimeFactors {

	public static void main(String[] args) {

		Util.startClock();
		Number n = new Number(647L);

		while (n.getValue() <= 1000001L) {
			if (n.getPrimeDivisorsAsMap().get(Number.DIVISORS).size() >= 4) {
				Long firstNumber = n.getValue();
				n.setValue(n.getValue() + 1);
				if (n.getPrimeDivisorsAsMap().get(Number.DIVISORS).size() >= 4) {
					n.setValue(n.getValue() + 1);
					if (n.getPrimeDivisorsAsMap().get(Number.DIVISORS).size() >= 4) {
						n.setValue(n.getValue() + 1);
						if (n.getPrimeDivisorsAsMap().get(Number.DIVISORS).size() >= 4) {
							System.out.println("Divisors : " + n.getPrimeDivisorsAsMap().get(Number.DIVISORS));
							System.out.println("Divisors : " + n.getPrimeDivisorsAsMap().get(Number.POWERS));
							System.out.println("Found it : " + firstNumber);
							break;
						}
					}
				}
			}
			n.setValue(n.getValue() + 1);
		}

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

}
