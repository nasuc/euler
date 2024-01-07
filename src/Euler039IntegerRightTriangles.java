public class Euler039IntegerRightTriangles {

	public static void main(String[] args) {

		Util.startClock();
		int start = 1000;
		int end = 12;
		int maxSol = 0;
		int theP = 0;

		for (int p = start; p >= end; p--) {
			int solP = 0;

			for (int a = p / 3; a <= p - 2; a++) {
				for (int b = p / 3; b >= 1; b--) {
					int c = p - a - b;
					if (a * a == b * b + c * c) {
						solP++;
						if (solP > maxSol) {
							maxSol = solP;
							theP = p;
						}
					}
				}
			}
		}
		System.out.println("Result : " + theP);
		System.out.println("Solutions: " + maxSol);
		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

}
