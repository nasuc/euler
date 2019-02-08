public class Euler031 {

	static int target = 200;
	static int solutions = 0;
	static int[] coins = { 200, 100, 50, 20, 10, 5, 2, 1 };
	static int maxLevel = coins.length;
	static int[] cardinal = { 1, 2, 4, 10, 20, 40, 100, 200 };
	static int[] solution = { 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {

		backTrack(0, 0);
		System.out.println("\nNumber of solutions: " + solutions);

	}

	static void backTrack(int level, int amount) {
		if (level < maxLevel && amount < target) {
			for (int i = 0; i <= cardinal[level]
					&& amount + coins[level] * i <= target; i++) {
				solution[level] = i;
				backTrack(level + 1, amount + coins[level] * i);
				init(level);
			}
		} else {
			if (isSolution()) {
				printSolution();
				solutions++;
			}
		}
	}

	static void init(int level) {
		solution[level] = 0;
	}

	static boolean isSolution() {
		int sum = 0;
		for (int i = 0; i < maxLevel; i++) {
			sum += solution[i] * coins[i];
		}
		return (sum == target);
	}

	static void printSolution() {
		System.out.print("\nS[" + (solutions + 1) + "]: ");
		for (int i = 0; i < maxLevel; i++) {
			if (solution[i] != 0) {
				if (coins[i] >= 100) {
					System.out.print(solution[i] + "x" + (int) (coins[i] / 100)
							+ "€  ");
				} else {
					System.out.print(solution[i] + "x" + coins[i] + "¢  ");
				}
			}
		}
	}

}
