public class Euler048SelfPowers {

	public static void main(String[] args) {

		Util.startClock();
		Number n = new Number(0L);
		Long sum = 0L;
		
		while (n.getValue() < 1000L) {
			n.setValue(n.getValue() + 1);
			sum += n.selfPower(10);
			//System.out.println("Sum is : " + sum);
		}
		System.out.println("Sum is : " + sum);
		

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

}
