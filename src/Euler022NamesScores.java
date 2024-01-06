import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Euler022NamesScores {

	public static void main(String[] args) {

		long st = Util.getClock();

		List<String> names = loadNames();
		Collections.sort(names);
		long sum = 0;

		for (int index = 0; index < names.size(); index++) {
			String name = names.get(index);
			int nameScore = 0;
			for (int i = 0; i < name.length(); i++) {
				nameScore += (name.charAt(i) - 64) * (index + 1);
			}
			sum += nameScore;
			System.out.println(index + 1 + " : " + name);
		}

		System.out.println("Summ of all amiable numbers is " + sum);
		System.out.println("Elapsed time in miliseconds: " + Util.calculateDurationinNano(st) / 1000000);

	}

	private final static List<String> loadNames() {
		System.out.println("Reading names file ...");
		long st = Util.getClock();
		Path filePath = Paths.get("C:\\Users\\Alex\\eclipse-workspace\\Euler\\src\\p022_names.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> names = new ArrayList<>();
		while (scanner.hasNext()) {
			names.add(scanner.next());
		}
		System.out.println("Reading of names file completed in " + Util.calculateDurationinNano(st) / 1000000 + " miliseconds");
		return names;
	}

}
