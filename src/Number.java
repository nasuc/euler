import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Number {

	private Long value;

	private static final List<Integer> PRIMES = loadPrimes();
	private static final HashMap<Integer, Void> PRIMES_MAP = buildMap(PRIMES);
	private static final Integer LAST_PRIME = PRIMES.get(PRIMES.size() - 1);

	/**
	 * @return the value
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Number value) {
		this.value = value.getValue();
	}

	/**
	 * Receives a Long as the parameter
	 * 
	 * @param value
	 */
	public Number(Long value) {
		this.value = value;
	}
	
	/**
	 * Checks if the number given as a parameter is prime.
	 */
	private boolean isPrime(Long valueToCheck) {
		if (valueToCheck <= 1) return false;
		if (valueToCheck == 2) return true;
		if (valueToCheck % 2 == 0) {
			return false;
		}
		if (PRIMES.size() > 0 && valueToCheck <= LAST_PRIME) {
			if (PRIMES_MAP.containsKey(Integer.valueOf((int) valueToCheck.longValue()))) {
				return true;
			}
		}
		for (Integer smallPrime : PRIMES) {
			if (valueToCheck % smallPrime == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if the current number is prime.
	 */
	public boolean isPrime() {
		return isPrime(this.value);
	}

	/**
	 * Returns a list with all the prime divisors of a number. Returns empty list if
	 * the number is prime
	 */
	public List<Integer> getPrimeDivisors() {
		Long n = value;
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while (n >= PRIMES.get(i) && i < PRIMES.size() - 1) {
			if (n % PRIMES.get(i) == 0) {
				list.add(PRIMES.get(i));
				n = n / PRIMES.get(i);
				i = 0;
			} else {
				i++;
			}
		}
		return list;
	}

	/**
	 * Counts the number of divisors of a number (including 1 and itself)
	 * 
	 */
	public int getNumberOfDivisors() {
		Integer prevDivisor = 1;
		int divisorCardinality = 0;
		int product = 1;
		List<Integer> divisors = getPrimeDivisors();
		for (Integer divisor : divisors) {
			if (divisor == prevDivisor) {
				divisorCardinality++;
			} else {
				product *= divisorCardinality + 1;
				prevDivisor = divisor;
				divisorCardinality = 1;
			}
		}
		product *= divisorCardinality + 1;
		return product;
	}

	/**
	 * Returns a list with all the divisors of a number. Returns list with 1 and
	 * itself if the number is prime
	 */
	public List<Long> getDivisors() {
		List<Long> list = new ArrayList<Long>();
		Long root = (long) Math.sqrt(value);
		for (Long l = 1L; l <= root; l = l + 1) {
			if (value % l == 0) {
				list.add(l);
				if (!l.equals(value / l)) {
					list.add(value / l);
				}
			}
		}
		Collections.sort(list);
		return list;
	}

	/**
	 * Sum of all divisors of the number (excluding itself);
	 * 
	 */
	public Long getSumOfDivisors() {
		Long sum = 0L;
		for (Long l : getDivisors()) {
			sum += l;
		}
		sum -= value;
		return sum;
	}

	/**
	 * Returns the factoradic representation of n. len represents the length of the
	 * array to be permuted. First permutation is 0. To get 100th permutation, for
	 * example, use 99 as parameter for n
	 * 
	 * @param factoradicArray
	 * @return
	 */
	public int[] factoradic(int len) {
		long n = (long) value;
		int[] factoradicArray = new int[len];
		int i = 1;
		while (n != 0) {
			factoradicArray[len - i] = (int) (n % i);
			n = n / i;
			i++;
		}
		return factoradicArray;
	}

	/**
	 * Returns the next prime number strictly greater than the current number
	 * 
	 * @return
	 */
	public Number getNextPrime() {
		Number result = new Number(0l);
		if (PRIMES.size() > 0 && value < LAST_PRIME) {
			// the next prime number is in the list of pre-loaded primes
			int index = PRIMES.indexOf(Integer.valueOf(value.intValue()));
			if (index >= 0) {
				// number is prime so return the next element in the list
				result.setValue(Long.valueOf(PRIMES.get(index + 1)));
			} else {
				// number is not prime so search for the next prime number
				for (Integer smallPrime : PRIMES) {
					if (smallPrime > value) {
						result.setValue(Long.valueOf(smallPrime.longValue()));
						break;
					}
				}
			}

		} else {
			// the next prime number must be calculated
			result.setValue(value);
			if (value.longValue() % 2 == 0) {
				result.setValue(value + 1);
			}

			while (!result.isPrime()) {
				result.setValue(result.getValue() + 2);
			}
		}

		return result;

	}
	
	/**
	 * Returns the previous prime number strictly smaller than the current number
	 * 
	 * @return
	 */
	public Number getPreviousPrime() {
		Number result = new Number(0l);
		if (PRIMES.size() > 0 && value < LAST_PRIME) {
			// the previous prime number is in the list of pre-loaded primes
			int index = PRIMES.indexOf(Integer.valueOf(value.intValue()));
			if (index >= 0) {
				// number is prime so return the previous element in the list
				if (index == 0) {
					result.setValue(1L);
				} else {
					result.setValue(Long.valueOf(PRIMES.get(index - 1)));
				}
			} else {
				// number is not prime so search for the previous prime number
				for (Integer smallPrime : PRIMES) {
					if (smallPrime > value) {
						int nextIndex = PRIMES.indexOf(Integer.valueOf(smallPrime.intValue()));
						result.setValue(Long.valueOf(PRIMES.get(nextIndex - 1)));
						break;
					}
				}
			}

		} else {
			// the previous prime number must be calculated
			result.setValue(value);
			if (result.isPrime()) {
				result.setValue(result.getValue() - 2);
			}
			if (value.longValue() % 2 == 0) {
				result.setValue(value - 1);
			}
			while (!result.isPrime()) {
				result.setValue(result.getValue() - 2);
			}
		}

		return result;

	}

	/**
	 * private method to load the prime number from file in memory
	 */
	private final static List<Integer> loadPrimes() {
		System.out.println("Reading prime numbers from file ...");
		long st = Util.getClock();
		Path filePath = Paths.get("src\\primes.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Integer> numbers = new ArrayList<>();
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				numbers.add(scanner.nextInt());
			} else {
				scanner.next();
			}
		}
		System.out.println("Reading of prime numbers complete in " + Util.calculateDurationinNano(st) / 1000000 + " miliseconds");
		return numbers;
	}
	
	private static HashMap<Integer, Void> buildMap(List<Integer> primes) {
		HashMap<Integer, Void> map = new HashMap<Integer, Void>();
		for (Iterator<Integer> iterator = primes.iterator(); iterator.hasNext();) {
			map.put((Integer) iterator.next(), null);
		}
		return map;
	}
	
	public boolean isLeftTruncatable() {
		return this.value < 10 ? false : isLeftTruncatable(this.value);
	}
	
	private boolean isLeftTruncatable(Long localValue) {
		if (localValue < 10) {
			return isPrime(localValue);
		}
		if (isPrime(localValue)) {
			return isLeftTruncatable(localValue / 10);
		}
		return false;
	}
	
	public boolean isRightTruncatable() {
		return this.value < 10 ? false : isRightTruncatable(this.value);
	}
	
	private boolean isRightTruncatable(Long localValue) {
		if (localValue < 10) {
			return isPrime(localValue);
		}
		if (isPrime(localValue)) {
			String localValueString = localValue.toString();
			localValue = Long.parseLong(localValueString.substring(1));
			return isRightTruncatable(localValue);
		}
		return false;
	}
	
	public boolean isPandigital() {
		String valueAsString = this.value.toString();
		int length = valueAsString.length();
		for (int i = 1; i<= length ; i++) {
			if (!valueAsString.contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
	}

}
