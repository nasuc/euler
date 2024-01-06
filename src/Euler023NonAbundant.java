import java.util.ArrayList;
import java.util.List;

public class Euler023NonAbundant {

	public static void main(String[] args) {

		long st = Util.getClock();

		List<Long> abundantNumbers = new ArrayList<Long>();
		long sum = 0;

		for (long index = 1; index <= 28123; index++) {

			Number number = new Number(index);
			//System.out.println("Number: " + number.getValue());
			//System.out.println("Divisiors: " + number.getDivisors());
			//System.out.println("Sum of divisiors: " + number.getSumOfDivisors());
			if (number.getSumOfDivisors() > number.getValue()) {
				abundantNumbers.add(number.getValue());
				//System.out.println(number.getValue() + " is an abundant number.");
			}

			boolean canBeWritten = false;
			int i = 0;
			while (i < abundantNumbers.size() && abundantNumbers.get(i) <= index / 2) {
				if (abundantNumbers.contains(index - abundantNumbers.get(i))) {
					canBeWritten = true;
				}
				i++;
			}
			if (!canBeWritten) {
				
				sum += index;
				//System.out.println(index + " cannot be written as the sum of non-abundant numbers.");
				System.out.println(sum);
			}

		}

		// for (long index = 12; index <= 28123; index++){ }

		System.out.println("Summ of all non-abundant numbers is " + sum);
		System.out.println("Elapsed time in miliseconds: " + Util.calculateDurationinNano(st) / 1000000);

	}

}
