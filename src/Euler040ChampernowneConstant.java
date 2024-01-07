public class Euler040ChampernowneConstant {

	public static void main(String[] args) {

		Util.startClock();

		String decimals = "";

		for (int i = 1; true; i++) {
			decimals += String.valueOf(i);
			if (decimals.length() >= 1000000) {
				break;
			}
			// System.out.println(decimals);
		}

		int result = 1;
		for (int i = 0; i<=6 ; i++) {
			int index = (int) (Math.pow(10, i) - 1);
			System.out.println("index : " + index);
			System.out.println("digit : " + Integer.valueOf(String.valueOf(decimals.charAt(index))));
			result *= Integer.valueOf(String.valueOf(decimals.charAt(index)));
		}

		System.out.println("Result : " + result);
		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

}
