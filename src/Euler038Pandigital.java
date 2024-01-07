public class Euler038Pandigital {

	public static void main(String[] args) {

		Util.startClock();
		int start = 9876;
		int end = 9183;
		
		for (int i=start; i>= end ; i--) {
			String p1 = String.valueOf(i);
			String p2 = String.valueOf(i*2);
			String p = p1 + p2;
			if (isPandigital(p)) {
				System.out.println("Largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2,3,...,n) where n>1 : " + p);
				break;
			}
		}
		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis()); 
	}

	private static boolean isPandigital(String p) {
		if (p.contains("1") && p.contains("2") && p.contains("3") && p.contains("4") && p.contains("5") && p.contains("6") && p.contains("7") && p.contains("8") && p.contains("9")) {
			return true;
		}
		return false;
	}

}
