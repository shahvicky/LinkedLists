import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsTest {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("ab");
		words.add("aab");
		words.add("abb");
		words.add("abab");
		words.add("abaaaba");
		words.add("add");
		words.add("booook");
		words.add("break");
		
		List<String> testWords = words.stream().filter(x -> x.startsWith("b") && x.length() > 5)
				.collect(Collectors.toList());
		System.out.println(testWords);
		Set<String> set = words.stream().collect(Collectors.toSet());
		System.out.println(set);
		int[] numbers = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};
		int sum = Arrays.stream(numbers).sum();
		int s = "ibti".compareTo("sdfdf");
		System.out.println(sum);
	}

}
