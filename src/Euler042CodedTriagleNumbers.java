import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Euler042CodedTriagleNumbers {

	public static void main(String[] args) {
		
		Util.startClock();
		Set<Integer> triangles = new HashSet<>(Arrays.asList(1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120,136, 153, 171, 190));
		
		int count = 0;
		for (String word : loadWords()) {
			//System.out.println(word + " : " + getWordValue(word));
			if (triangles.contains(getWordValue(word))) {
				count ++;
			}
		}
		System.out.println("Found words : " + count);

		Util.stopClock();
		System.out.println("Duration in millis : " + Util.getDurationInMillis());
	}
	
	private final static List<String> loadWords() {
		System.out.println("Reading words file ...");
		long st = Util.getClock();
		Path filePath = Paths.get("0042_words.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> words = new ArrayList<>();
		while (scanner.hasNext()) {
			words.add(scanner.next());
		}
		System.out.println("Reading of words file completed in " + Util.calculateDurationinNano(st) / 1000000 + " miliseconds");
		return words;
	}
	
	private static Integer getWordValue(String word) {
		Integer value = 0;
		for (int i = 0 ; i < word.length() ; i++) {
			value += (int)word.charAt(i) - 64;
		}
		return value;
	}
	
	

}
