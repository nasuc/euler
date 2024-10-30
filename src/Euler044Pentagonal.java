import java.util.ArrayList;
import java.util.List;

public class Euler044Pentagonal {
	
	private static Long minimum = 1L;
	private static int maxElems = 10000;
	private static int maxParser = 3000;
	
	public static void main(String[] args) {

		Util.startClock();

		List<Long> pentagonals = generatePentagonals(maxElems);
		System.out.println("Sum : " + pentagonals);
		
		for (int lowIndex = 0; lowIndex < maxParser - 1; lowIndex++) {
			for (int highIndex = lowIndex; highIndex < maxParser; highIndex++) {
				Long low = pentagonals.get(lowIndex);
				Long high = pentagonals.get(highIndex);
				Long diff = high - low;
				Long sum = high + low;
				if (pentagonals.contains(diff) && pentagonals.contains(sum)) {
					System.out.println("Found low " + low + " and high " + high);
					if (diff > minimum) {
						System.out.println("Found a new minimum : " + diff);
						minimum = diff;
					}
				}
			}
		}

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}
	
	private static List<Long> generatePentagonals(int cardinality) {
		List<Long> pentagonals = new ArrayList<>();
		for (long n = 1; n<=cardinality; n++ ) {
			pentagonals.add((n * (3 * n - 1) / 2));
		}
		return pentagonals;
	}

}
