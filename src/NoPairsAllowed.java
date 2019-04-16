

import java.util.ArrayList;
import java.util.List;

public class NoPairsAllowed {
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
		System.out.println(minimal(words));
	}
	
	static List<Integer> minimal(List<String> words) {
		List<Integer> min = new ArrayList<>();
		
		for(String word : words){
			int count = 0;
			char last = word.charAt(0);
			int pos = 1;
			while(pos<word.length()) {
				if(word.charAt(pos) == last) {
					count++;
					last = '#';
					pos++;
				} else {
					last = word.charAt(pos);
					pos++;
				}
			}
			min.add(count);
			count=0;
		}
		return min;
	}
}
