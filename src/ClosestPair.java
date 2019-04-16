import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ClosestPair {

	public static void main(String[] args) {
		int[] arr = {5, 1, 3, 7};
		int target = 14;
		boolean flag = true;
		int minDiff = Integer.MAX_VALUE;
		int[] pair = new int[2];
		HashSet<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		set.add(target-arr[0]);
		for(int i=1; i<arr.length; i++) {
			int diff = target-arr[i];
			if(set.contains(arr[i])) {
				pair[0] = diff;
				pair[1] = arr[i];
				System.out.println(true + " " + Arrays.toString(pair));
				flag= false;
			} else {
				
				set.add(diff);
			}
		}
		if(flag)
			System.out.println(false + " " + Arrays.toString(pair));
	}

}

