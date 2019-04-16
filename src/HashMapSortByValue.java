import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HashMapSortByValue {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("FIve", 5);
		map.put("Three", 3);
		map.put("six", 6);
		map.put("four", 4);
		map.put("one", 1);
		map.put("five", 5);
		map.put("nine", 9);
		
		System.out.println(sortByValue(map));
	}
	
	static HashMap<String, Integer> sortByValue(HashMap<String, Integer> map) {
		
		Comparator<Map.Entry<String, Integer>> mapComp = new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				return entry1.getValue()-entry2.getValue();
			}
		};
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, mapComp);
		HashMap<String, Integer> res = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry : list)
			res.put(entry.getKey(), entry.getValue());
		return res;
	}

}
