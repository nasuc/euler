public class Euler046GolbachConjecture {

	public static void main(String[] args) {

		Util.startClock();

		for (Number n = new Number(35L); n.getValue() <= 1000001L; n.setValue(n.getValue() + 2)) {
			if (n.isPrime()) continue;
			boolean isGoldbach = false;
			Number newN = n.getPreviousPrime();
			while (newN.getValue()>=2) {
				if (isTwiceSquared(n.getValue() - newN.getValue())) {
					isGoldbach = true;
					//System.out.println(n.getValue() + " = " + newN.getValue() + " + 2 * " + (n.getValue() - newN.getValue()/2));
					break;
				}
				newN = newN.getPreviousPrime();
			}
			if (!isGoldbach) {
				System.out.println("Found : " + n.getValue());
				break;
			}
		}

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

	private static boolean isTwiceSquared(Long number) {
		if (number % 2 != 0) return false;
		number /= 2;
		long root = (long) Math.sqrt(number);
		return  root * root == number;
	}

}
