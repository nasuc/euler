public class Util {
	public static long startClock() {
		return System.nanoTime();
	}

	public static long stopClock(long startDate) {
		return System.nanoTime() - startDate;
	}

}
