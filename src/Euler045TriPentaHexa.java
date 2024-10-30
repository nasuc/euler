import java.util.ArrayList;
import java.util.List;

public class Euler045TriPentaHexa {

	private static int maxElemsTri = 130000;
	private static int maxElemsPenta = 120000;
	private static int maxElemsHexa = 110000;

	public static void main(String[] args) {

		Util.startClock();

		List<Long> triagonals = generateTriagonals(maxElemsTri, 286);
		List<Long> pentagonals = generatePentagonals(maxElemsPenta, 166);
		List<Long> hexagonals = generateHexagonals(maxElemsHexa, 144);
		System.out.println("Hexagonals : " + hexagonals);

		for (int hexIndex = 0; hexIndex < hexagonals.size(); hexIndex++) {
			Long theHex = hexagonals.get(hexIndex);
			if (triagonals.contains(theHex) && pentagonals.contains(theHex)) {
				System.out.println("Tri, Penta, Hexa number is: " + theHex);
				break;
			}
		}

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}

	private static List<Long> generateTriagonals(int cardinality, int minimum) {
		List<Long> triagonals = new ArrayList<>();
		for (long n = minimum; n <= cardinality; n++) {
			triagonals.add((n * (n + 1) / 2));
		}
		return triagonals;
	}

	private static List<Long> generatePentagonals(int cardinality, int minimum) {
		List<Long> pentagonals = new ArrayList<>();
		for (long n = minimum; n <= cardinality; n++) {
			pentagonals.add((n * (3 * n - 1) / 2));
		}
		return pentagonals;
	}

	private static List<Long> generateHexagonals(int cardinality, int minimum) {
		List<Long> hexagonals = new ArrayList<>();
		for (long n = minimum; n <= cardinality; n++) {
			hexagonals.add((n * (2 * n - 1)));
		}
		return hexagonals;
	}

}
