

import java.util.*;
public class WordsSplit {

	public static void main(String[] args) {
		String str = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's akjhf food";
		String[] ignore = {"and", "he", "the", "to", "is"};
		HashMap<String, Integer> map = new HashMap<>();
		String[] words = str.split("[^a-zA-Z]");
		System.out.println(Arrays.toString(words));
		for(int i=0; i<words.length; i++) {
			if(words[i].length()==0)
				continue;
		  if(map.containsKey(words[i].toLowerCase())) {
		    map.put(words[i].toLowerCase(), map.get(words[i].toLowerCase())+1);
		  } else {
		    map.put(words[i].toLowerCase(), 1);
		  }
		}
		System.out.println(Arrays.toString(map.entrySet().toArray()));
		for(int i=0; i<ignore.length; i++) {
			if(map.containsKey(ignore[i].toLowerCase())) {
				map.remove(ignore[i].toLowerCase());
			}
		}
		System.out.println(Arrays.toString(map.entrySet().toArray()));
		int max = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
		    if (entry.getValue().compareTo(max) > 0)
		    {
		        max = entry.getValue();
		    }
		}
		List<String> ans = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == max) {
				ans.add(entry.getKey());
			}
		}
		System.out.println(ans.toString());
	}

}