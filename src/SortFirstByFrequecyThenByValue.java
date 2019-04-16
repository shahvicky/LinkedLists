import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortFirstByFrequecyThenByValue {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(5);
		arr.add(4);
		arr.add(3);
//		int[] arr = {4,5,6,5,4,3}; //3,6,4,4,5,5
		
		
		
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			if(!map.containsKey(i))
				map.put(i, 1);
			else
				map.put(i, map.get(i)+1);
		}
		Comparator<Map.Entry<Integer, Integer>> mapComp = new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
				int ret = entry1.getValue() - entry2.getValue();
				if(ret == 0)
					ret = entry1.getKey()-entry2.getKey();
				return ret;
			}
		};
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, mapComp);
		arr.clear();
		for(Map.Entry<Integer, Integer> entry : list) {
			int num = entry.getValue();
			while(num>0) {
				arr.add(entry.getKey());
				num--;
			}
				
		}
//			res.put(entry.getKey(), entry.getValue());
		System.out.println(arr);
		
	}
	
	

}
