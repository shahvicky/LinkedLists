

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	static List<List<String>> splits = new ArrayList<>();
	public static void main(String[] args) {

		String[] listOfWords = { "rockstar", "rock", "star", "rocks", "tar", "super", "high", "way", "highway",
				"superhighway", "hi","gh" };
		List<String> words = new ArrayList<>(Arrays.asList(listOfWords));
		Set<String> wordSet = new HashSet<>();
		for(String word : listOfWords)
			wordSet.add(word);
		List<String> wordMap = new ArrayList<>();
		for(int i=0; i<words.size(); i++) {
			wordMap.add(words.get(i));
			wordCanSplit(words.get(i), 0, wordMap, wordSet);
			wordMap.remove(wordMap.size()-1);
			
		}
		System.out.println(splits);

	}
	
	static void wordCanSplit(String word, int start, List<String> curr,  Set<String> set) {
		if(start == word.length()) {
			if(curr.size()>2) {
				splits.add(new ArrayList<>(curr));
			}
			return;
		}
		StringBuilder str = new StringBuilder();
		for(int i=start; i<word.length(); i++) {
			str.append(word.charAt(i));
			if(set.contains(str.toString())) {
				curr.add(str.toString());
				wordCanSplit(word, i+1, curr, set);
				curr.remove(curr.size()-1);
			}
		}
		return;
		
	}
	
	

}
