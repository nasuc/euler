import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Euler problem 29 - Distinct Powers (brute force)
 * 
 * @author Alex
 *
 */
public class Euler029DistinctPowers {

	public static void main(String[] args) throws InterruptedException {

		long st = Util.startClock();

		int size = 100;
		Set<BigDecimal> myCollection = new HashSet<BigDecimal>();
		
		for (int i = 2; i <= size; i++) {
			for (int j = 2; j <= size; j++) {
				BigDecimal number = new BigDecimal(i);
				number = number.pow(j);
				myCollection.add(number);
			}
		}

		System.out.println("Number of elements in myCollection: " + myCollection.size());
		System.out.println("Elapsed time (in miliseconds): " + Util.stopClock(st) / 1000000);

	}


}
