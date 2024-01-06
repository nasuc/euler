public class Util {
	
	private static Long startInNono;
	private static Long durationInNano;
	
	public static long getClock() {
		return System.nanoTime();
	}

	public static long calculateDurationinNano(long startClockinNano) {
		return System.nanoTime() - startClockinNano;
	}
	
	/**
	 * Sets a static variable as the time in nanoseconds when this method was invoked 
	 * @return
	 */
	public static long startClock() {
		startInNono = System.nanoTime();
		return startInNono;
	}
	
	/**
	 * Returns the duration in nanoseconds
	 * @return
	 */
	public static Long stopClock() {
		durationInNano = startInNono == null ? null : System.nanoTime() - startInNono;
		return durationInNano;
	}
	
	/**
	 * Returns the duration in milliseconds
	 * @return
	 */
	public static Long getDurationInMillis() {
		return durationInNano == null ? null : durationInNano / 1000000;
	}

}
