/**
 * @author Vivek
 * @param: int[][] list -> {{1,4,5},{1,3,4},{2,6}}
 * @return: List<Integer> -> [1, 1, 2, 3, 4, 4, 5, 6]
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		int[][] lists = {{1,4,5},{1,3,4},{2,6}};
		
		List<Integer> ans = merge(lists);
		System.out.println(ans);
	}
	
	static List<Integer> merge(int[][] lists) {
		List<Integer> res = new ArrayList<>();
		if(lists.length == 0) {
			return res;
		}
		Comparator<int[]> comp = new Comparator<int[]>(){
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0]-arg1[0];
			}
		};
		PriorityQueue<int[]> heap = new PriorityQueue<>(comp);
		for(int i=0; i<lists.length; i++) {
			if(lists[i].length>0) {
				heap.add(new int[]{lists[i][0], i, 0});
			}
		}
		
		while(!heap.isEmpty()) {
			int[] top = heap.poll();
			res.add(top[0]);
			int listNo = top[1];
			int pos = top[2];
			if(lists[listNo].length-1 > pos) {
				heap.add(new int[]{lists[listNo][pos+1], listNo, pos+1});
			}
		}
		
		return res;
	}

}

