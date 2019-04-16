import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {

	public static void main(String[] args) {
		int[] cand = {3, 4, 7, 7, 6, 6};
		
		
	}
	
	public static int solution(int[] T) {
		int half = T.length/2;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int candy : T) {
			map.put(candy, map.getOrDefault(candy, 0)+1);
		}
		int type = 0, my = 0, give = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			my += 1;
			give += entry.getKey()-1;
			if(my == half) {
				return half;
			} else if(give == half) {
				
			}
		}
		return 0;
		
	}

}
